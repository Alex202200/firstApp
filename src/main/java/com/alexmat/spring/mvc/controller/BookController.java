package com.alexmat.spring.mvc.controller;


import com.alexmat.spring.mvc.entity.Book;
import com.alexmat.spring.mvc.entity.Person;
import com.alexmat.spring.mvc.service.BookService;
import com.alexmat.spring.mvc.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    PersonService personService;

    @RequestMapping("/books")
    public String showAllBook(Model model) {
        List<Book> allBooks = bookService.getAllBook();
        model.addAttribute("books", allBooks);

        return "all-book";
    }

    @RequestMapping("/book/add")
    public String showAddBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);

        return "add-book";
    }

    @RequestMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);

        return "redirect:books";
    }


    @GetMapping("/book/details/{id}")
    public  String showBook(@PathVariable("id") int id, Model model){
        Book book=bookService.getBook(id);
        model.addAttribute("book", book);

        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("allPersons", allPersons);
        return "book";
    }


    @RequestMapping("/book/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model){
          Book book = bookService.getBook(id);
          model.addAttribute("book"  , book);
        return "add-book";
    }


    @RequestMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @PostMapping("/book/assign/{bookId}")
    public String assignBook(@PathVariable("bookId") int bookId, @RequestParam("person") int personId) {
        Book book = bookService.getBook(bookId);
        Person person = personService.getPerson(personId);

        book.setPerson(person);
        bookService.saveBook(book);

        return "redirect:/books";
    }

    @RequestMapping(value = "/book/release/{id}", method = RequestMethod.POST)
    public String releaseBook(@PathVariable int id) {
        Book book = bookService.getBook(id);
        book.setPerson(null);
        bookService.saveBook(book);
        return "redirect:/books";
    }


}
