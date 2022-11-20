package com.mehdilagdimi.chiforek;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//the following are used with Spring, but not needed for now because Spring Boot autoconfiguration scans entities in and enables jpa repos in default package with @SpringBootApplication
//@EntityScan(basePackages = "com.mehdilagdimi.chiforek.entity")
//@EnableJpaRepositories(basePackages = "com.mehdilagdimi.chiforek.repository")
@SpringBootApplication
@RestController
public class ChiforekApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChiforekApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

}
