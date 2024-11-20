package com.amigoscodeproject.amigoscodeproject.dao;

import com.amigoscodeproject.amigoscodeproject.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {
    Person insertPerson(UUID id, Person person);
    List<Person> getPersons();

    default Person insertPerson(Person person){
        UUID id  = UUID.randomUUID();
        return  insertPerson(id, person);
    }

   
}
