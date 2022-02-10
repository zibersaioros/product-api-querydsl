package com.rs.api_querydsl.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(Utf8Encoding.Config.class)
public @interface Utf8Encoding {
    class Config {
        @Bean
        public CharacterEncodingFilter characterEncodingFilter() {
            return new CharacterEncodingFilter("UTF-8", true);
        }
    }
}
