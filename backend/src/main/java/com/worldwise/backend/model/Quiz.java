package com.worldwise.backend.model;

import lombok.Getter;

@Getter
public class Quiz {
    private Integer id;
    private String name;
    private String prompt;
    private String answer;
    private String file;
}
