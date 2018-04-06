package com;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ProviderServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderServiceApplication.class).web(true).run(args);
    }

}
