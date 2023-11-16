package com.example.springbootgraphql.domain.dto;

import com.example.springbootgraphql.domain.models.Author;

public record BookInput(
        String title,
        String subject
) {
}
