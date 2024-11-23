package com.amigoscodeproject.amigoscodeproject.dao;

import com.amigoscodeproject.amigoscodeproject.model.Person;

import java.util.*;
import java.util.UUID;

public interface PersonDao {
    Person insertPerson(UUID id, Person person);

    default Person insertPerson(Person person){
        UUID id  = UUID.randomUUID();
        return  insertPerson(id, person);
    }

    List<Person> getPersons();

    Optional<Person> selectPersonById(UUID id);

    String deletePerson(UUID id);

    int updatePerson(UUID id, Person person);
}
