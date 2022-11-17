package com.puritys.spring.configuration;

import com.puritys.spring.module.CommonModule;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;

@Slf4j
@Configuration
@EnableGuiceModules
@ComponentScan(basePackages = "com.puritys.spring.exception")
public class CommonConfiguration {
    public CommonConfiguration() {
        log.info("CommonConfiguration init ");
    }

    @Bean
    public static CommonModule bindGuiceCommonModule() {
        return new CommonModule();
    }

    @Bean
    public Config getConfig() {
        return ConfigFactory.load("default.conf");
    }

}
