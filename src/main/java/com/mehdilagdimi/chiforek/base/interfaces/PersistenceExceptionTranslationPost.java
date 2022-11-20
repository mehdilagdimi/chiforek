package com.mehdilagdimi.chiforek.base.interfaces;

import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;

public interface PersistenceExceptionTranslationPost {
    @Bean
    default PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
