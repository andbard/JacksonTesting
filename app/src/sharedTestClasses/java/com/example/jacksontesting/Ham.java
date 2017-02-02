package com.example.jacksontesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Ham {

    private int id;
    @JsonIgnoreProperties("ham")
    private Egg egg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Egg getEgg() {
        return egg;
    }

    public void setEgg(Egg egg) {
        this.egg = egg;
    }
}
