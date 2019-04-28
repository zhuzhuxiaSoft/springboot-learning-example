package org.spring.springboot.router;

import org.spring.springboot.handler.CityHandler;
import org.spring.springboot.handler.CityHandler2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CityRouter {


    @Bean
    public RouterFunction<ServerResponse> routeCity(CityHandler cityHandler,CityHandler2 cityHandler2) {
        return RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),cityHandler::helloCity)
        		.andRoute(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),cityHandler2::helloCity)
        		.andRoute(RequestPredicates.GET("/hello2").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),cityHandler::helloCity2);
    }

}
