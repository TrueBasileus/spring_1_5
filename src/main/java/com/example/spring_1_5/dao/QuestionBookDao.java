package com.example.spring_1_5.dao;

import com.example.spring_1_5.domain.Question;

import java.util.List;

public interface QuestionBookDao {

    List<Question> getAllQuestions();
}
