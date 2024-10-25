package com.nodoantivirus.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Value("${swagger.title}")
    String title;
    @Value("${swagger.version}")
    String version;
    @Value("${swagger.description}")
    String description;

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title(title).version(version).description(description));
    }
}