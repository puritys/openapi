package com.puritys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@RestController
//@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = {"org.openapitools", "com.puritys.spring.api" , "com.puritys.spring.configuration"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
