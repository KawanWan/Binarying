package com.binarying.binproject;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Especifique o caminho da sua API
                .allowedOrigins("http://localhost:8000") // URL permitida para acesso
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // Métodos HTTP permitidos
    }
}
