package com.example.springbootgraphql.domain.models;

import com.example.springbootgraphql.domain.dto.AuthorInput;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String fullname;
    private String email;
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList();

    public Author(AuthorInput input){
        this.fullname = input.fullname();
        this.email = input.email();
    }
}
