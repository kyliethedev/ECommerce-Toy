package com.kyliethedev.ecommercetoy.domain.item;

import com.kyliethedev.ecommercetoy.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Getter
@DiscriminatorValue("B")
@Entity
public class Book extends Item {

    private String author;

    private String isbn;

    // Setter
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    @Builder
    private Book(Long id, String name, int price, int stockQuantity, List<Category> categories, String author, String isbn) {
        super(id, name, price, stockQuantity, categories);
        this.author = author;
        this.isbn = isbn;
    }
}
