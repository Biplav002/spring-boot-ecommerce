package com.luv2code.ecommerce.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    @NotNull
    private String appUrl;

    public String getAppUrl() {
        return appUrl;
    }
}