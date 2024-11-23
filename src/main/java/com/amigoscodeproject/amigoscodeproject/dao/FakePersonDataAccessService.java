package com.amigoscodeproject.amigoscodeproject.dao;

import com.amigoscodeproject.amigoscodeproject.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.Map;

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
    public String deletePerson(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isEmpty()){
            return  "No Person Found with this id";
        }else{
         DB.remove(personMaybe.get());
         return "Person Deleted Successfully";
        }
    }

    @Override
    public int updatePerson(UUID id, Person newPerson) {
        return selectPersonById(id).map(person -> {
            int indexToDelete = DB.indexOf(person);
            if(indexToDelete>=0){
                DB.set(indexToDelete, new Person(id, newPerson.getName()));
                return 1;
            }
             return  0;
        }).orElse(0);
    }


}
