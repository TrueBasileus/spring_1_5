package com.example.spring_1_5.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionBook {
    private List<Question> questions;

    public void print() {
        questions.forEach(System.out::println);
    }

}
