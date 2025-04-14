package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class to enable CORS for the 
 * frontend client (React application on http://localhost:3000)
 */
@Configuration
public class WebConfig {

    /**
     * Defines a WebMvcConfigurer bean.
     * Enables CORS for API endpoints so that the frontend can communicate
     * with the backend without issue.
     * 
     * @return a WebMvcConfigurer with CORS settings applied
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Allow requests from http://localhost:3000 to access any endpoint starting with /api/
                registry.addMapping("/api/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
