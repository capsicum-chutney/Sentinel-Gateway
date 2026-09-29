package com.sentinel.sentinel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class GatewayController {

    private final RestClient restClient;
    private final RouteConfig routeConfig;

    public GatewayController(RestClient restClient, RouteConfig routeConfig) {
        this.restClient = restClient;
        this.routeConfig = routeConfig;
    }
    
    @GetMapping("/**")
public String gateway(HttpServletRequest request) {

    String path = request.getRequestURI();
    String backendUrl = routeConfig.getRoutes().get(path);
    

    return restClient.get()
        .uri(backendUrl)
        .retrieve()
        .body(String.class);
}
}