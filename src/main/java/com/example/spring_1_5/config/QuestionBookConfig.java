package com.example.spring_1_5.config;

import com.example.spring_1_5.domain.QuestionBook;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.example.spring_1_5.service.QuestionBookService;

@Configuration
@PropertySource("classpath:application.yml")
public class QuestionBookConfig {

    @Bean
    public QuestionBookService createQuestionBookService(MessageSource messageSource) {
        return new QuestionBookService(messageSource);
    }

    @Bean
    public QuestionBook createQuestionBook(QuestionBookService questionBookService) {
        return new QuestionBook(questionBookService.loadQuestions());
    }
}
