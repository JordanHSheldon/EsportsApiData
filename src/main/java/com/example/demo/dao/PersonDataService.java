package com.example.demo.dao;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
                 .filter(person -> person.getId().equals(id))
                 .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional <Person> personMaybe = getPersonById(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person newPerson) {
        return getPersonById(id)
                .map(person-> {
                    int indexOfPersonToUpdate = DB.indexOf(person);
                    if (indexOfPersonToUpdate >= 0){
                        DB.set(indexOfPersonToUpdate, new Person(id, newPerson.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
