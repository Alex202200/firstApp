package com.alexmat.spring.mvc.service;

import com.alexmat.spring.mvc.dao.BookDAOImpl;
import com.alexmat.spring.mvc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDAOImpl bookDAO;

    @Override
    @Transactional
    public List<Book> getAllBook() {
        return bookDAO.getAllBook();
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDAO.saveBook(book);
    }

    @Override
    @Transactional
    public Book getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
       bookDAO.deleteBook(id);
    }

    @Override
    @Transactional
    public List<Book> getBooksByPersonId(int personId) {
        return bookDAO.getBooksByPersonId(personId);
    }
}
