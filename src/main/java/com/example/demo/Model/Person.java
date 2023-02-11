package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Person {
    private final UUID id;

    @NotBlank
    public String name;

    public Person(@JsonProperty("id") UUID id,@Valid @NonNull @NotEmpty @JsonProperty("name") String name) {
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


