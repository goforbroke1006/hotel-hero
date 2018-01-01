package com.gfb.hotelHero.vkontakte;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class VkontakteClient {

    private String baseUrl;
    private String apiVersion;
    private String accessToken;

    private Properties properties;

    public VkontakteClient(String baseUrl, String apiVersion, String accessToken) {
        this.baseUrl = baseUrl;
        this.apiVersion = apiVersion;
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public VkontakteClient setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public Properties getProperties() {
        return properties;
    }

    public VkontakteClient setProperties(Properties properties) {
        this.properties = properties;
        return this;
    }

    public Object exec(BaseRequest request) {
        WebTarget target = ClientBuilder.newClient()
                .target(baseUrl)
                .path(request.getMethodName())
                .queryParam("access_token", accessToken)
                .queryParam("v", apiVersion);

        for (Map.Entry<String, Object> param : request.getContext().entrySet()) {
            target = target.queryParam(param.getKey(), param.getValue());
        }

        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(""));

        String responseContent = response.readEntity(String.class);

        return deserializeVkResponse(request.getResponseModel(), responseContent);
    }

    public Object deserializeVkResponse(Class aClass, String responseContent) {
        JsonObject mainObject = (new JsonParser()).parse(responseContent).getAsJsonObject();
        JsonElement responseItem = mainObject.get("response");

        if (null == responseItem) {
            // TODO: logging
            return null;
        }

        Object result = null;
        try {
            result = (new ObjectMapper()).readValue(responseItem.toString(), aClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    private MessagesPort messagesPort;

    public MessagesPort getMessagesPort() {
        if (null == messagesPort)
            messagesPort = new MessagesPort(this);
        return messagesPort;
    }

}
