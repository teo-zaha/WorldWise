package com.worldwise.backend.model;

import lombok.Getter;

@Getter
public class Question {
    private Integer id;
    private String prompt;
    private String answer;
}
