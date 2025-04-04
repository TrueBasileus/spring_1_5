package com.example.spring_1_5;

import com.example.spring_1_5.domain.QuestionBook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.spring_1_5.service.StudentTestService;

@SpringBootApplication
public class Spring15Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring15Application.class, args);
        StudentTestService studentTestService = context.getBean(StudentTestService.class);
        studentTestService.test(context.getBean(QuestionBook.class));
    }
}
