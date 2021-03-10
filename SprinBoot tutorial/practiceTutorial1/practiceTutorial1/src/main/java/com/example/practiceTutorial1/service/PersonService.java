package com.example.practiceTutorial1.service;

import com.example.practiceTutorial1.dao.PersonDao;
import com.example.practiceTutorial1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    //need to get a reference of the actual person Dao
    private final PersonDao personDao; //injecting the actual constructor

    @Autowired //autowiring into the PersonDao interface
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {//많은 implementation있을 수 있으므로 자세히 뭔지 서줌. 이름으로qualifier로
        this.personDao = personDao;
    }

    //have a method to insert a new person
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
    //have a method to retrieve data
    public List<Person> getAllPeople(){
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public int deletePerson(UUID id){
        return personDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);

    }

}
