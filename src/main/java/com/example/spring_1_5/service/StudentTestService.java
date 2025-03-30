package com.example.spring_1_5.service;

import com.example.spring_1_5.domain.Answer;
import com.example.spring_1_5.domain.Question;
import com.example.spring_1_5.domain.QuestionBook;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

@PropertySource("classpath:application.yml")
@Service
@Setter
public class StudentTestService {
    @Value("${answers.for.pass}")
    int correctAnswersForPass;
    private MessageSource messageSource;
    @Autowired
    public StudentTestService(MessageSource messageSource){
        this.messageSource = messageSource;
    }
    public String test(QuestionBook questions) {
        System.out.println(messageSource.getMessage("initial.message", null, Locale.getDefault()));
        try (Scanner scan = new Scanner(System.in)) {
            int correctAnswers = 0;
            for (Question question : questions.getQuestions()) {
                System.out.print(question.getTextQuestion() + " ");
                List<String> answers = question.getAnswers().stream().map(Answer::toString).collect(Collectors.toList());
                String[] studentsAnswers = scan.nextLine().split(",[\\s]*");
                for(String studentsAnswer: studentsAnswers) {
                    if (answers.stream().anyMatch(ans -> ans.equals(studentsAnswer))) {
                        answers.remove(studentsAnswer);
                    }
                }
                if(answers.isEmpty()) {
                    correctAnswers++;
                }
            }
            String str = correctAnswers < correctAnswersForPass ? messageSource.getMessage("test.failed.message", null, Locale.getDefault()) : messageSource.getMessage("test.passed.message", null, Locale.getDefault());
            System.out.println(str);
            return str;
        }
    }
}
