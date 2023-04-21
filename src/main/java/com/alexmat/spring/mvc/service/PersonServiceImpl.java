package com.alexmat.spring.mvc.service;

import com.alexmat.spring.mvc.dao.PersonDAO;
import com.alexmat.spring.mvc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {


    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }


    @Override
    @Transactional
    public void savePerson(Person person) {
        personDAO.savePerson(person);
    }


    @Override
    @Transactional
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void deletePerson(int id) {
      personDAO.deletePerson(id);
    }
}
