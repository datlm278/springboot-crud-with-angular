package com.example.springbootcrudwithangular.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Value("${ssw-enable-swagger2}")
    private boolean enableSwagger;

    @Value("${ssw.cors.origins}")
    private String crossOrigins;

    @Value("${ssw.methods.allowed}")
    private String allowedMethods;

    @Value("${ssw.header.allowed}")
    private String allowedHeaders;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        WebMvcConfigurer.super.configurePathMatch(configurer);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/rest/v1/**")
                .allowCredentials(true)
                .allowedOrigins(crossOrigins.split(","))
                .allowedMethods(allowedMethods.split(","))
                .allowedHeaders(allowedHeaders.split(","))
                .maxAge(3600)
                .exposedHeaders("Content-Disposition");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        if(enableSwagger) {
            registry.addRedirectViewController("/swagger-ui/", "swagger-ui.html");
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //enabling swagger-ui part for visual documentation
        if (enableSwagger) {
            registry.addResourceHandler("swagger-ui.html")
                    .addResourceLocations("classpath:/META-INF/resources/");
        }
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
