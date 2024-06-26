package com.VeraRchik.bankapplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig
     implements WebMvcConfigurer {
    private static final Long MAX_AGE = 3600L;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedHeaders()
//                .allowedOrigins("http://localhost:3000") // Разрешить доступ с этого домена
                .allowedOrigins("http://147.45.150.25:3000") // Разрешить доступ с этого домена
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }


}