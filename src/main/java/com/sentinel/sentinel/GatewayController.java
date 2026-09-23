package com.sentinel.sentinel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
public class GatewayController {

    private final RestClient restClient;
    private final RouteConfig routeConfig;

    public GatewayController(RestClient restClient, RouteConfig routeConfig) {
        this.restClient = restClient;
        this.routeConfig = routeConfig;
    }
    
    @GetMapping("/data")
public String getData() {
    return restClient.get()
            .uri(routeConfig.getRoutes().get("/data"))
            .retrieve()
            .body(String.class);
}

    @GetMapping("/users")
public String getUsers() {

    return restClient.get()
            .uri(routeConfig.getRoutes().get("/users"))
            .retrieve()
            .body(String.class);
}
}