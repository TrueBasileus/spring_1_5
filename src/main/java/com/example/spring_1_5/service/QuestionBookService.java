package com.example.spring_1_5.service;

import com.example.spring_1_5.domain.Question;
import java.util.List;

public interface QuestionBookService {
    List<Question> getAllQuestions();
}