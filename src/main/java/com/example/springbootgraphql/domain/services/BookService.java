package com.example.springbootgraphql.domain.services;

import com.example.springbootgraphql.domain.dto.BookInput;
import com.example.springbootgraphql.domain.models.Book;
import com.example.springbootgraphql.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    public Book create(BookInput book, String email) {
        Book newBook = new Book(book);
        newBook.setAuthor(authorService.findAuthorByEmail(email).get());
        return bookRepository.save(newBook);
    }

    public Optional<Book> findBook(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

}
