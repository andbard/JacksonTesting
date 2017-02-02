package com.example.jacksontesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Egg {

    private int id;
    @JsonIgnoreProperties("egg")
    private Ham ham;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ham getHam() {
        return ham;
    }

    public void setHam(Ham ham) {
        this.ham = ham;
    }
}
