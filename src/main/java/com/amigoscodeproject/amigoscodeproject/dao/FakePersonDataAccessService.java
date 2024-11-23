package com.amigoscodeproject.amigoscodeproject.dao;

import com.amigoscodeproject.amigoscodeproject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements  PersonDao{

    private  static List<Person> DB = new ArrayList<>();
    @Override
    public  Person insertPerson(UUID id , Person person){
        DB.add(new Person(id, person.getName()));
      return   DB.stream()
                .filter(p -> p.getId() == id) // Filter by id
                .findFirst() // Find the first match
                .orElse(null);
    }

    @Override
    public List<Person> getPersons(){
      return  DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public Object deletePerson(UUID id) {
        return null;
    }

    @Override
    public Object updatePerson(UUID id, Person person) {
        return null;
    }


}
