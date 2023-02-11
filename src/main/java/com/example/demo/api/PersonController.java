package com.example.demo.api;

import com.example.demo.Model.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PersonService;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){

        this.personService = personService;
    }
    @PostMapping
    public void insertPerson(@RequestBody @Valid Person person){
        personService.insertPerson(person);
    }
    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") @Valid UUID id){
        return personService.getPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable("id") @Valid UUID id){
        personService.deletePersonById(id);
    }
    @Validated
    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") @NonNull @Valid UUID id, @NonNull @Valid @RequestBody Person newPerson){
        personService.updatePerson(id, newPerson);
    }

}
