package com.fu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by fu on 2017/12/9.
 */
@Controller
public class BookController {

    @GetMapping("/books")
    public String list(){
        return "books";
    }
}
