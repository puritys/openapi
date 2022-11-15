package com.puritys.spring.configuration;

import com.typesafe.config.ConfigFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages = "com.puritys.spring.exception")
public class CommonConfiguration {
    public CommonConfiguration() {
        log.info("CommonConfiguration init ");
    }

    @Bean
    public Config getConfig() {
        return ConfigFactory.load("default.conf");
    }

}
