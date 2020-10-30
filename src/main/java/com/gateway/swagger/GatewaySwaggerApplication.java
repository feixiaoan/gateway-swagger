package com.gateway.swagger;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xiaofei
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class GatewaySwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaySwaggerApplication.class,args);
    }

}
