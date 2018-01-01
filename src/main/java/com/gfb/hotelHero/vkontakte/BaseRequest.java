package com.gfb.hotelHero.vkontakte;

import java.util.Map;

public abstract class BaseRequest {

    public abstract String getMethodName();

    public abstract Map<String, Object> getContext();

    public abstract Class getResponseModel();

}
