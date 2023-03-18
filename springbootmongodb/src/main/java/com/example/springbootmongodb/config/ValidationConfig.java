package com.example.springbootmongodb.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configurable
public class ValidationConfig {

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener()
    {
        return new ValidatingMongoEventListener(validator().getValidator());
    }
    @Bean
    public LocalValidatorFactoryBean validator()
    {
        return new LocalValidatorFactoryBean();
    }
}
