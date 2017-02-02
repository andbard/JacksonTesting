package com.example.jacksontesting;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Bar {

    private int id;
    @JsonIgnoreProperties("bar")
    private Foo foo;

    public Bar() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }
}
