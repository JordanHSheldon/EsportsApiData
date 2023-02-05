package com.example.demo.dao;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataService implements PersonDao {
    private static List<Person> DB = new ArrayList<Person>();
    @Override
    public int insertPerson(UUID id, Person person){
        DB.add(new Person(id,person.getName()));
        return 0;
    }

    public List<Person> getAllPersons(){
        return DB;
    }
}
