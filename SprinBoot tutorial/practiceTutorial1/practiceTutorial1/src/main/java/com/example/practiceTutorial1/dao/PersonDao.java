package com.example.practiceTutorial1.dao;

import com.example.practiceTutorial1.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

//define actual interface that we will allow us to have any implementation for our database
public interface PersonDao {
    //we want to insert a person into the actual database
    //return integer //list 사용해서 데이터베이스 시늉할거야
    //methods
    //insert a person with a given id
    int insertPerson(UUID id, Person person);

    //default method- it generates UUID ourselves or show ID
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    //this will return a list person
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);//and new person we want to update
}
