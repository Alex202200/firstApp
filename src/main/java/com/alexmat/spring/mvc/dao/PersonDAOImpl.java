package com.alexmat.spring.mvc.dao;

import com.alexmat.spring.mvc.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Person> getAllPersons() {
        Session session = sessionFactory.getCurrentSession();
        List<Person> allPerson = session.createQuery("from Person", Person.class).getResultList();
        return allPerson;
    }

    @Override
    public void savePerson(Person person) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(person);
    }

    @Override
    public Person getPerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Person person = session.get(Person.class, id);
      //  person.getBooks().size();

        return person;
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Person where id=:personId");
        query.setParameter("personId", id);
        query.executeUpdate();

    }
}
