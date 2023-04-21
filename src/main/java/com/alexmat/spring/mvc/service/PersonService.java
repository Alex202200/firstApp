package com.alexmat.spring.mvc.service;

import com.alexmat.spring.mvc.entity.Person;

import java.util.List;

public interface PersonService {

    public List<Person> getAllPersons();

    public void savePerson(Person person);

    public Person getPerson(int id);

    public void deletePerson(int id);
}
