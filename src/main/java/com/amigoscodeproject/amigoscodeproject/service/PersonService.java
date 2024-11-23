package com.amigoscodeproject.amigoscodeproject.service;

import com.amigoscodeproject.amigoscodeproject.dao.PersonDao;
import com.amigoscodeproject.amigoscodeproject.model.Person;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private  final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getPersons(){
        return personDao.getPersons();
    }

    public Optional<Person> selectPersonById(UUID id){
        return personDao.selectPersonById(id);
    }
}
