package com.worldwise.backend.dto;

import lombok.Builder;

@Builder
public record QuestionDto(
    Integer id,
    String prompt,
    String answer) {
}
