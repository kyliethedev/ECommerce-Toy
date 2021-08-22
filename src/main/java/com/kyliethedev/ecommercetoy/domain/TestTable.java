package com.kyliethedev.ecommercetoy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class TestTable {

    @Id
    private int id;

    private String name;

    @Builder
    public TestTable(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
