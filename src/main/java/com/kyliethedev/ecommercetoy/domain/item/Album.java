package com.kyliethedev.ecommercetoy.domain.item;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@DiscriminatorValue("A")
@Entity
public class Album extends Item{
    private String artist;
    private String etc;

    // Setter
    public void setArtist(String artist) { this.artist = artist; }
    public void setEtc(String etc) { this.etc = etc; }
}
