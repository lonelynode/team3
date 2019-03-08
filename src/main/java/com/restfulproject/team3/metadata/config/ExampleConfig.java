package com.restfulproject.team3.metadata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

@Component
public class ExampleConfig {
    @Bean
    public ExampleMatcher setExampleConfig(){
        return  ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true)
                .withIgnorePaths("version");
    }
}
