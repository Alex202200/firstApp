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
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private BookService bookService;

    @RequestMapping("/persons")
    public String showAllPerson(Model model) {
        List<Person> allPersons = personService.getAllPersons();
        model.addAttribute("allpers", allPersons);

        return "all-person";
    }

    // Отображение страницы добавления человека
    @RequestMapping("/persons/add")
    public String showAddPersonForm(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);

        return "add-person";
    }



    // Обработка POST-запроса для добавления человека в базу данных
    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }


    @GetMapping("/person/details/{id}")
    public String showPerson(@PathVariable int id, Model model) {
        Person person = personService.getPerson(id);
          person.getBooks().size();
        model.addAttribute("person", person);
        return "person";
    }


    // Отображение страницы изменения человека
    @RequestMapping("/persons/edit/{id}")
    public String showEditPerson(@PathVariable("id") int id, Model model) {
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "add-person";
    }


    @RequestMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        List<Book> books = bookService.getBooksByPersonId(id);
        for (Book book : books) {
            book.setPerson(null);
            bookService.saveBook(book);
        }

        personService.deletePerson(id);
        return "redirect:/persons";
    }

}