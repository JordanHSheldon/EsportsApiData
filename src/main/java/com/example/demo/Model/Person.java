package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Person {
    private final UUID id;
    public String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    // getters
    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
}


