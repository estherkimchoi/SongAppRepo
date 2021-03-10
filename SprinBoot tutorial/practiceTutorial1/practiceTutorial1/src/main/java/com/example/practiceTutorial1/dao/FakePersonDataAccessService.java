package com.example.practiceTutorial1.dao;

import com.example.practiceTutorial1.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//implementation of PersonDao

//this class need to be instantiated as a bean so that we can inject it in other classes
@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao{

    //define list
    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        //search within our database and see we have a person with the given ID by Streaming our database// we use Java Stream
        return DB.stream().filter(person -> person.getId().equals(id) ).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        //it returns Optional
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isPresent()){
            DB.remove(personMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person update) {
        return selectPersonById(id).map(p -> {
                                        int indexOfPersonToDelete = DB.indexOf(p);
                                        if(indexOfPersonToDelete >= 0) {
                                           DB.set(indexOfPersonToDelete, new Person(id, update.getName()));
                                           return 1;
                                        }
                                        return 0;
                                     } )
                                        .orElse(0);
    }
}
