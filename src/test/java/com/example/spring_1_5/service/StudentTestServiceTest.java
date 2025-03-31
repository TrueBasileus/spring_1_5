package com.example.spring_1_5.service;




import com.example.spring_1_5.domain.Answer;
import com.example.spring_1_5.domain.Question;
import com.example.spring_1_5.domain.QuestionBook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.mockito.Mockito.when;

@SpringBootTest
public class StudentTestServiceTest {

    @Autowired
    private StudentTestService service;
    @MockBean
    private MessageSource messageSource;

    @Mock
    private QuestionBook questionBook;

    @BeforeEach
    void setUp(){
        service.setCorrectAnswersForPass(1);
    }

    @Test
    public void testWithCorrectAnswers(){
        List<Question> testQuestions = new ArrayList<>();
        testQuestions.add(new Question("The 2 most populated cities in Russia", List.of(new Answer("Moscow"), new Answer("Saint-Petersburg"))));

        when(questionBook.getQuestions()).thenReturn(testQuestions);
        when(messageSource.getMessage("test.passed.message", null, Locale.getDefault()))
                .thenReturn("Test passed");

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream("Saint-Petersburg, Moscow".getBytes()));
        String result = service.test(questionBook);

        Assertions.assertEquals("Test passed", result);

        System.setIn(originalIn);
    }

    @Test
    public void testWithIncorrectAnswers(){
        List<Question> testQuestions = new ArrayList<>();
        testQuestions.add(new Question("The 2 most populated cities in Russia", List.of(new Answer("Moscow"), new Answer("Saint-Petersburg"))));

        when(questionBook.getQuestions()).thenReturn(testQuestions);
        when(messageSource.getMessage("test.failed.message", null, Locale.getDefault()))
                .thenReturn("Test failed");

        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream("Kazan, Saint-Petersburg".getBytes()));
        String result = service.test(questionBook);

        Assertions.assertEquals("Test failed", result);

        System.setIn(originalIn);
    }
}
