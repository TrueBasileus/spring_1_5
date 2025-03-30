package com.example.spring_1_5.service;

import com.example.spring_1_5.domain.Answer;
import com.example.spring_1_5.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Data
@AllArgsConstructor
public class QuestionBookService {
    MessageSource messageSource;

    public List<Question> loadQuestions(){
        List<Question> result = new ArrayList<>();

        // Загружаем вопросы
        for (int i = 1; i <= 2; i++) {
            String questionKey = "survey.question" + i;
            String questionText = messageSource.getMessage(questionKey, null, Locale.getDefault());

            String answerKey = "survey.answer" + i;
            String answerText = messageSource.getMessage(answerKey, null, Locale.getDefault());

            String[] answerStrings = answerText.split(",");
            List<Answer> answers = new ArrayList<>();

            for (String answerStr : answerStrings) {
                answers.add(new Answer(answerStr.trim())); // Добавляем ответ, удаляя лишние пробелы
            }

            Question questionObj = new Question(questionText, answers);
            result.add(questionObj);
        }

        return result;
    }

}
