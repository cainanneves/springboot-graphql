package com.example.springbootgraphql.domain.services;

import com.example.springbootgraphql.domain.dto.AuthorInput;
import com.example.springbootgraphql.domain.models.Author;
import com.example.springbootgraphql.domain.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author create(AuthorInput author) {
        return authorRepository.save(new Author(author));
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorRepository.findByEmail(email);
    }
}
