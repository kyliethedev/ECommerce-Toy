package com.kyliethedev.ecommercetoy.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@DiscriminatorValue("B")
@Entity
public class Book extends Item {
    private String author;
    private String isbn;

    // Setter
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
}
