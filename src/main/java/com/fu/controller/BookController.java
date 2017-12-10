package com.fu.controller;

import com.fu.pojo.Book;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by fu on 2017/12/9.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String list() {
        return "books";
    }

    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model){
        Book book = bookService.findOne(id);
        if(null == book){
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

}
