package com.example.spring_1_5.service.impl;

import com.example.spring_1_5.dao.QuestionBookDao;
import com.example.spring_1_5.domain.Question;
import com.example.spring_1_5.service.QuestionBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionBookServiceImpl implements QuestionBookService {
    private final QuestionBookDao questionBookDao;

    @Override
    public List<Question> getAllQuestions() {
        return questionBookDao.getAllQuestions();
    }
}