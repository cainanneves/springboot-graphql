package com.example.springbootgraphql.domain.models;

import com.example.springbootgraphql.domain.dto.BookInput;
import lombok.*;
import org.hibernate.annotations.Where;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "books")
@Where(clause = "is_active = true")
public class Book {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String isbn = UUID.randomUUID().toString();
    private String title;
    private String subject;
    @ManyToOne
    private Author author;
    private LocalDate createdAt = LocalDate.now();
    @Column(name = "is_active")
    private boolean active = true;

    public Book (BookInput input) {
        this.title = input.title();
        this.subject = input.subject();
    }

}
