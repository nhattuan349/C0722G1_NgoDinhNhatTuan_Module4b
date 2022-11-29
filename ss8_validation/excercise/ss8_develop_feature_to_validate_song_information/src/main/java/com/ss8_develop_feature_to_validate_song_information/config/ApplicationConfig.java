package com.ss8_develop_feature_to_validate_song_information.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class ApplicationConfig {
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("msg/validation_message");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
