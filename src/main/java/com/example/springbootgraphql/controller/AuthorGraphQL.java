package com.example.springbootgraphql.controller;

import com.example.springbootgraphql.domain.dto.AuthorInput;
import com.example.springbootgraphql.domain.models.Author;
import com.example.springbootgraphql.domain.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AuthorGraphQL {

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public Optional<Author> findAuthor(@Argument String email) {
        return authorService.findAuthorByEmail(email);
    }

    @MutationMapping
    public Author createAuthor(@Argument AuthorInput author) {
        return authorService.create(author);
    }

}
