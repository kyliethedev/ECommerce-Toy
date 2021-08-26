package com.kyliethedev.ecommercetoy.domain;

import com.kyliethedev.ecommercetoy.domain.item.Album;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class ItemTest {

    @Test
    public void albumBuildTest() {
        //given
        String name = "name";
        int price = 1000;
        int stockQuantity = 5;
        String artist = "artist";

        Album album = Album.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .artist(artist)
                .build();

        //when
        //then
        assertThat(album.getName()).isEqualTo(name);
        assertThat(album.getPrice()).isEqualTo(price);
        assertThat(album.getArtist()).isEqualTo(artist);
    }
}
