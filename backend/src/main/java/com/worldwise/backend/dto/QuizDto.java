package com.worldwise.backend.dto;

import lombok.Builder;

@Builder
public record QuizDto(
        Integer id,
        String name,
        String prompt,
        String answer,
        String file
) {
}
