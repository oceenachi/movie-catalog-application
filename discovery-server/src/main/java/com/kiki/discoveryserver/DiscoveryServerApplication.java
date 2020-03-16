package com.kiki.discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaServer
//@EnableDiscoveryClient
@PropertySource("classpath:application.properties")
public class DiscoveryServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(DiscoveryServerApplication.class, args);
    }

}
