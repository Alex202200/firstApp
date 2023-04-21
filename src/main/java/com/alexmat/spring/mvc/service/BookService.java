package com.alexmat.spring.mvc.service;

import com.alexmat.spring.mvc.entity.Book;

import java.util.List;

public interface BookService {

    public List<Book> getAllBook();

    public void saveBook(Book book);

    public  Book getBook(int id);

    public void deleteBook(int id);

    List<Book> getBooksByPersonId(int personId);
}
