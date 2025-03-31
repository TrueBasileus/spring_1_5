package com.example.spring_1_5.service;

import com.example.spring_1_5.domain.Answer;
import com.example.spring_1_5.domain.Question;
import com.example.spring_1_5.domain.QuestionBook;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class QuestionBookService {
    MessageSource messageSource;

    public QuestionBook loadQuestions(){
        List<Question> result = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            String questionKey = "survey.question" + i;
            String questionText = messageSource.getMessage(questionKey, null, Locale.getDefault());

            String answerKey = "survey.answer" + i;
            String answerText = messageSource.getMessage(answerKey, null, Locale.getDefault());

            String[] answerStrings = answerText != null ? answerText.split(",") : new String[0];
            List<Answer> answers = new ArrayList<>();

            for (String answerStr : answerStrings) {
                answers.add(new Answer(answerStr.trim()));
            }

            Question questionObj = new Question(questionText, answers);
            result.add(questionObj);
        }

        return new QuestionBook(result);
    }

}
