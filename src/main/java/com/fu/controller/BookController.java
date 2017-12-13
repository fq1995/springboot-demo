package com.fu.controller;

import com.fu.pojo.Book;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by fu on 2017/12/9.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 书单列表
     * @param model
     * @return
     */
    @GetMapping("/books")
    public String list(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("books", bookList);
        return "books";
    }

    /**
     * 书单详情
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model){
        Book book = bookService.findOne(id);
        if(null == book){
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

    /**
     * 跳转input提交页面
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(){
        return "input";
    }

    /**
     *提交一个书单信息
     */
    @PostMapping("/books")
    public String post(Book book){
        bookService.save(book);
        return "redirect:/books";
    }
}
