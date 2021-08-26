package com.kyliethedev.ecommercetoy.domain.item;

import com.kyliethedev.ecommercetoy.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Getter
@DiscriminatorValue("A")
@Entity
public class Album extends Item{

    private String artist;

    private String etc;

    // Setter
    public void setArtist(String artist) { this.artist = artist; }
    public void setEtc(String etc) { this.etc = etc; }

    @Builder
    private Album(Long id, String name, int price, int stockQuantity, List<Category> categories, String artist, String etc) {
        super(id, name, price, stockQuantity, categories);
        this.artist = artist;
        this.etc = etc;
    }
}
