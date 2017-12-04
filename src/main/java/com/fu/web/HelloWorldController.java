package com.fu.web;

import com.fu.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fu on 2017/12/1.
 */
//@Controller
@RestController
@RequestMapping("/v1")
public class HelloWorldController {
//    @Value("${book.name}")
//    private String name;
//
//    @Value("${book.author}")
//    private String author;
//
//    @Value("${book.isbn}")
//    private String isbn;
//
//    @Value("${book.description}")
//    private String description;

    @Autowired
    private Book book;

    //    @RequestMapping(value = "/say",method = RequestMethod.GET)
    @PostMapping("/say")
    public String hello() {
        return "Hello Spring Boot";
    }


    @GetMapping("/books")
//    @ResponseBody
    public Object getAll(@RequestParam("page") int page, @RequestParam(value = "size",defaultValue = "10",required = false) int size) {


//        Map<String, Object> book = new HashMap<>();
//        book.put("name", name);
//        book.put("isbn", isbn);
//        book.put("author", author);
//        book.put("description", description);

        Map<String, Object> book2 = new HashMap<>();
        book2.put("name", "我的世界2");
        book2.put("isbn", "421431433");
        book2.put("author", "付强");

        List<Map> contents = new ArrayList<>();
//        contents.add(book);
        contents.add(book2);

        Map<String, Object> map = new HashMap<>();
        map.put("page",page);
        map.put("size",size);
        map.put("contents",contents);
        return map;
    }
//    public String getAll(){
//        return "books";
//    }

    /**
     * 正则表达式： {参数名：正则表达式规则}
     *
     * @param bid
     * @return
     */
    @GetMapping("/books/{id}")
    public Object getOne(@PathVariable("id") long bid) {

//        System.out.println("id=" + bid + " username=" + username);
//        Map<String, Object> book = new HashMap<>();
//        book.put("name", "我的世界");
//        book.put("isbn", "2321321312");
//        book.put("author", "付强");
//        book.put("uaername", username);
        return book;
    }

    @RequestMapping("/books")
    public Object post(@RequestParam("name") String name, @RequestParam("author") String author, @RequestParam("isbn") String isbn) {
        Map<String, Object> book = new HashMap<>();

        book.put("name",name);
        book.put("author",author);
        book.put("isbn",isbn);

        return book;
    }

}
