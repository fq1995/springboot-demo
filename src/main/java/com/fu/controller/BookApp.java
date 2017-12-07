package com.fu.controller;

import com.fu.pojo.Book;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */
@RestController
@RequestMapping("/v2")
public class BookApp {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll(){

        return bookService.findAll();
    }

    @PostMapping("/books")
//    public Book post(@RequestParam String name,
//                     @RequestParam String author,
//                     @RequestParam String description,
//                     @RequestParam int status){
//        Book book = new Book();
//        book.setAuthor(author);
//        book.setDescription(description);
//        book.setName(name);
//        book.setStatus(status);
//
//        return bookService.save(book);
//    }
    public Book post(Book book){
        return bookService.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id){
        return bookService.findOne(id);
    }

    @PutMapping("/books")
    public Book update(@RequestParam String name,
                       @RequestParam String author,
                       @RequestParam String description,
                       @RequestParam int status,
                       @RequestParam long id){
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setDescription(description);
        book.setName(name);
        book.setStatus(status);

        return bookService.save(book);
    }


    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id){
        bookService.deleteOne(id);
    }

    @PostMapping("/books/by")
    public List<Book> findBy(@RequestParam int len){
//        return bookService.findByJPQL(len);
        return bookService.findBySQL(len);
    }



}
