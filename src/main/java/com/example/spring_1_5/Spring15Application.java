package com.example.spring_1_5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.spring_1_5.service.impl.StudentTestServiceImpl;

@SpringBootApplication
@Slf4j
public class Spring15Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring15Application.class, args);
        StudentTestServiceImpl studentTestService = context.getBean(StudentTestServiceImpl.class);
        studentTestService.test();

    }
}
