package com.amigoscodeproject.amigoscodeproject.api;

import com.amigoscodeproject.amigoscodeproject.model.Person;
import com.amigoscodeproject.amigoscodeproject.service.PersonService;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
      return  personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getPersons() {
      return  personService.getPersons();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
      return  personService.selectPersonById(id).orElse(null);
    }
}
