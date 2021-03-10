package com.example.practiceTutorial1.api;

import com.example.practiceTutorial1.model.Person;
import com.example.practiceTutorial1.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    //have reference to the actual service
    private final PersonService personService;

    @Autowired //SpringBoot injects the actual service into this constructor
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping    //to tell Spring that this method is used as a post request
    public void addPerson(@RequestBody Person person){ //take the request body from postman, and then shovel that inside of this Person
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);//custom message,exception..to the actual client like 404 //여긴simply return null
    }

    @DeleteMapping(path ="{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person personToUpdate){
        personService.updatePerson(id, personToUpdate);
    }
}
