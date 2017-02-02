package com.example.jacksontesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Foo {

    private int id;
    @JsonIgnoreProperties("foo")
    private Bar bar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@JsonIgnoreProperties("foo")
    public Bar getBar() {
        return bar;
    }

    //@JsonIgnoreProperties("foo")
    public void setBar(Bar bar) {
        this.bar = bar;
    }
}
