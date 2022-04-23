package com.sena.gatewayservise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:application-${spring.profiles.active:default}.properties", ignoreResourceNotFound = true)
public class GatewayServiseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServiseApplication.class, args);
    }
}
