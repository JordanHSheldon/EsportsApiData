package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Player {
    private final UUID id;
    @NotBlank
    public String name;
    public String lname;
    @NotBlank
    public String alias;


    public Player(@JsonProperty("id") UUID id,@Valid @NonNull @NotEmpty @JsonProperty("name") String name,@Valid @NonNull @NotEmpty @JsonProperty("lname") String lname,@Valid @NonNull @NotEmpty @JsonProperty String alias) {
        this.id = id;
        this.name = name;
        this.lname = lname;
        this.alias = alias;
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