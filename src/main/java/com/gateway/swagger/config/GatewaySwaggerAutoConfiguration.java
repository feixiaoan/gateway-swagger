package com.gateway.swagger.config;

import com.gateway.swagger.support.SwaggerResourceHandler;
import com.gateway.swagger.support.SwaggerSecurityHandler;
import com.gateway.swagger.support.SwaggerUiHandler;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * @author xiaofei
 */
//@RequiredArgsConstructor
@Configuration
@AllArgsConstructor
//@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
//@ComponentScan("com.gateway.swagger.support")
public class GatewaySwaggerAutoConfiguration {

    private final SwaggerResourceHandler swaggerResourceHandler;

    private final SwaggerSecurityHandler swaggerSecurityHandler;

    private final SwaggerUiHandler swaggerUiHandler;

//    @Bean
//    public WebFluxSwaggerConfiguration fluxSwaggerConfiguration() {
//        return new WebFluxSwaggerConfiguration();
//    }

    @Bean
    public RouterFunction swaggerRouterFunction() {
        return RouterFunctions
                .route(RequestPredicates.GET("/swagger-resources").and(RequestPredicates.accept(MediaType.ALL)),
                        swaggerResourceHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/ui")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerUiHandler)
                .andRoute(RequestPredicates.GET("/swagger-resources/configuration/security")
                        .and(RequestPredicates.accept(MediaType.ALL)), swaggerSecurityHandler);
    }

}
