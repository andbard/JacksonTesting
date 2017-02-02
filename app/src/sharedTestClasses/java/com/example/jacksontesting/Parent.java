package com.example.jacksontesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Parent {

    private int id;
    @JsonIgnoreProperties("parent")
    private Child child;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
