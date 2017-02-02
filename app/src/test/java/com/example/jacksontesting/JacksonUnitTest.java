package com.example.jacksontesting;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class JacksonUnitTest {

    @Rule
    public ExpectedException expectedJsonMappingException = ExpectedException.none();

    ObjectMapper mapper;

    Foo foo;
    Bar bar;

    Egg egg;
    Ham ham;

    Parent parent;
    Child child;

    @Before
    public void init() {
        mapper = new ObjectMapper();

        foo = new Foo();
        bar = new Bar();
        foo.setId(1);
        bar.setId(2);
        foo.setBar(bar);
        bar.setFoo(foo);

        egg = new Egg();
        ham = new Ham();
        egg.setId(1);
        ham.setId(2);
        egg.setHam(ham);
        ham.setEgg(egg);

        parent = new Parent();
        child = new Child();
        parent.setId(1);
        child.setId(2);
        parent.setChild(child);
        child.setParent(parent);
    }

    @Test
    public void serialize_deserialize_foo_bar() throws IOException {
        String f = mapper.writeValueAsString(this.foo);
        String b = mapper.writeValueAsString(this.bar);
        System.out.println("f: " + f + "\nb: " + b);

        Bar bar = mapper.readValue(b, Bar.class);
        b = mapper.writeValueAsString(bar);
        Foo foo = mapper.readValue(f, Foo.class);
        f = mapper.writeValueAsString(foo);
        System.out.println("f: " + f + "\nb: " + b);

        foo = mapper.readValue(f, Foo.class);
        f = mapper.writeValueAsString(foo);
        bar = mapper.readValue(b, Bar.class);
        b = mapper.writeValueAsString(bar);
        System.out.println("f: " + f + "\nb: " + b);
    }

    @Test
    public void serialize_deserialize_egg_ham() throws IOException {
        String e = mapper.writeValueAsString(this.egg);
        String h = mapper.writeValueAsString(this.ham);
        System.out.println("e: " + e + "\nh: " + h);

        Egg egg = mapper.readValue(e, Egg.class);
        e = mapper.writeValueAsString(egg);
        Ham ham = mapper.readValue(h, Ham.class);
        h = mapper.writeValueAsString(ham);
        System.out.println("e: " + e + "\nh: " + h);

        ham = mapper.readValue(h, Ham.class);
        h = mapper.writeValueAsString(ham);
        egg = mapper.readValue(e, Egg.class);
        e = mapper.writeValueAsString(egg);
        System.out.println("e: " + e + "\nh: " + h);
    }

    @Test
    public void serialize_deserialize_parent_child() throws IOException {
        String p = mapper.writeValueAsString(this.parent);
        String c = mapper.writeValueAsString(this.child);
        System.out.println("p: " + p + "\nc: " + c);

        Parent parent = mapper.readValue(p, Parent.class);
        p = mapper.writeValueAsString(parent);
        Child child = mapper.readValue(c, Child.class);
        c = mapper.writeValueAsString(child);
        System.out.println("p: " + p + "\nc: " + c);

        child = mapper.readValue(c, Child.class);
        c = mapper.writeValueAsString(child);
        parent = mapper.readValue(p, Parent.class);
        p = mapper.writeValueAsString(parent);
        System.out.println("p: " + p + "\nc: " + c);
    }

    @Test
    public void serialize_deserialize_foo_bar_withoutThrowingException() throws IOException {
        String f = mapper.writeValueAsString(this.foo);
        String b = mapper.writeValueAsString(this.bar);
        System.out.println("f: " + f + "\nb: " + b);

        Foo foo = mapper.readValue(f, Foo.class);
        f = mapper.writeValueAsString(foo);
        Bar bar = mapper.readValue(b, Bar.class);
        b = mapper.writeValueAsString(bar);
        System.out.println("f: " + f + "\nb: " + b);
    }

    @Test
    public void serialize_deserialize_egg_ham_withoutThrowingException() throws IOException {
        String e = mapper.writeValueAsString(this.egg);
        String h = mapper.writeValueAsString(this.ham);
        System.out.println("e: " + e + "\nh: " + h);

        Ham ham = mapper.readValue(h, Ham.class);
        h = mapper.writeValueAsString(ham);
        Egg egg = mapper.readValue(e, Egg.class);
        e = mapper.writeValueAsString(egg);
        System.out.println("e: " + e + "\nh: " + h);
    }

    @Test
    public void serialize_deserialize_parent_child_throwException() throws IOException {
        String p = mapper.writeValueAsString(this.parent);
        String c = mapper.writeValueAsString(this.child);
        System.out.println("p: " + p + "\nc: " + c);

        Child child = mapper.readValue(c, Child.class);
        c = mapper.writeValueAsString(child);
        // the next call to readValue will throw the following (not really) expected exception
        expectedJsonMappingException.expect(com.fasterxml.jackson.databind.JsonMappingException.class);
        expectedJsonMappingException.expectMessage("No _valueDeserializer assigned");
        Parent parent = mapper.readValue(p, Parent.class);
        p = mapper.writeValueAsString(parent);
        System.out.println("p: " + p + "\nc: " + c);
    }

}
