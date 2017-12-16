package com.fu.controller;

import com.fu.pojo.Book;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

/**
 * Created by fu on 2017/12/5.
 */
@RestController
@RequestMapping("/v2")
public class BookApp {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    /*public Page<Book> getAll(){
        return bookService.findAllByPage();
//        return bookService.findAll();
    }*/
    public Page<Book> getAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return bookService.findAllByPage(new PageRequest(page,size,sort));
//        return bookService.findAll();
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
    public int findBy(@RequestParam long id){
//        return bookService.findByJPQL(len);
//        return bookService.findBySQL(len);
//        return bookService.updateByJPQL(status, id);
        return bookService.deleteByJPQL(id);
    }



}
