package com.example.springbootgraphql.domain.dto;

public record AuthorInput(
        String fullname,
        String email
) {
}
