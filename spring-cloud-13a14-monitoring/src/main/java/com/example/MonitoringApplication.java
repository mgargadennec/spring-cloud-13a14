package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import de.codecentric.boot.admin.config.EnableAdminServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class MonitoringApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringApplication.class, args);
    }
}
