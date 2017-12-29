package com.gfb.hotelHero.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.time.LocalDate;
import java.util.List;

//@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    public static final int CACHE_PERIOD = 31556926;

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(2);
        return resolver;
    }

    private final String[] resDirs = {
            "AdminLTE-2.4.2",
//            "bootstrap",
//            "bootstrap-datepicker",
//            "bootstrap-daterangepicker",
//            "bootstrap-wysihtml5",
//            "Font-Awesome",
//            "ionicons",
//            "jquery",
//            "jquery-ui",
//            "jvectormap",
            "css",
            "img",
            "js",
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        for (String resDir : resDirs)
            registry.addResourceHandler("/" + resDir + "/**")
                    .addResourceLocations("/" + resDir + "/")
                    .setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/AdminLTE-2.4.2/**").addResourceLocations("/AdminLTE-2.4.2/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/bootstrap/**").addResourceLocations("/bootstrap/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/bootstrap-datepicker/**").addResourceLocations("/bootstrap-datepicker/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/Font-Awesome/**").addResourceLocations("/Font-Awesome/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/ionicons/**").addResourceLocations("/ionicons/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/jvectormap/**").addResourceLocations("/jvectormap/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(CACHE_PERIOD);
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(CACHE_PERIOD);
    }
}
