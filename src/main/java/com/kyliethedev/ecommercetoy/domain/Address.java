package com.kyliethedev.ecommercetoy.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;

    // Setter
    public void setCity(String city) { this.city = city; }
    public void setStreet(String street) { this.street = street; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
}
