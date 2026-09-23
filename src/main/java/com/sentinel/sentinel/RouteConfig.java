package com.sentinel.sentinel;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class RouteConfig {

    private Map<String, String> routes = new HashMap<>();

    @Value("${routes.data}")
    private String dataUrl;

    @Value("${routes.users}")
    private String usersUrl;

    @PostConstruct
    public void initializeRoutes() {
        routes.put("/data", dataUrl);
        routes.put("/users", usersUrl);
    }

    public Map<String, String> getRoutes() {
        return routes;
    }
}