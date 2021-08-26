package com.kyliethedev.ecommercetoy.web.dto.Item;

import com.kyliethedev.ecommercetoy.domain.item.Album;
import com.kyliethedev.ecommercetoy.domain.item.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemSaveRequestDto {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
    private String artist;
    private String etc;
    private String author;
    private String isbn;

    @Builder
    public ItemSaveRequestDto(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public ItemSaveRequestDto setArtist(String artist) {
        this.artist = artist;
        return this;
    }

    public ItemSaveRequestDto setEtc(String etc) {
        this.etc = etc;
        return this;
    }

    public ItemSaveRequestDto setAuthor(String author) {
        this.author = author;
        return this;
    }

    public ItemSaveRequestDto setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public Album albumToEntity() {
        return Album.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .artist(artist)
                .etc(etc)
                .build();
    }

    public Book bookToEntity() {
        return Book.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .author(author)
                .isbn(isbn)
                .build();
    }
}
