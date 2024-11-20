package com.amigoscodeproject.amigoscodeproject.dao;

import com.amigoscodeproject.amigoscodeproject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
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
}
