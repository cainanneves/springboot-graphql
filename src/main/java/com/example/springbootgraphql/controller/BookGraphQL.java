package com.example.springbootgraphql.controller;

import com.example.springbootgraphql.domain.dto.BookInput;
import com.example.springbootgraphql.domain.models.Book;
import com.example.springbootgraphql.domain.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BookGraphQL {

    @Autowired
    private BookService bookService;

    @QueryMapping
    public Optional<Book> findBook(@Argument String isbn) {
        return bookService.findBook(isbn);
    }

    @MutationMapping
    public Book createBook(@Argument BookInput book, @Argument String email) {
        return bookService.create(book, email);
    }

}


