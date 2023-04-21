package com.alexmat.spring.mvc.dao;

import com.alexmat.spring.mvc.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl  implements BookDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Book> getAllBook() {
        Session  session = sessionFactory.getCurrentSession();
        List<Book> allBook= session.createQuery("from Book", Book.class).getResultList();
        return allBook;
    }

    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();

          session.saveOrUpdate(book);
    }

    @Override
    public Book getBook(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Book.class, id);
    }

    @Override
    public void deleteBook(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query =session.createQuery("delete from Book where id=:bookId");
        query.setParameter("bookId", id);
        query.executeUpdate();
    }

    @Override
    public List<Book> getBooksByPersonId(int personId) {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("SELECT b FROM Book b JOIN b.person p WHERE p.id = :personId",
                Book.class);
        query.setParameter("personId", personId);
        return query.getResultList();

    }
}

