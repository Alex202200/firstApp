package com.alexmat.spring.mvc.dao;

import com.alexmat.spring.mvc.entity.Person;

import java.util.List;

public interface PersonDAO {

    public List<Person> getAllPersons();

   public void savePerson(Person person);

   public Person getPerson(int id);

   public void deletePerson(int id);

}
