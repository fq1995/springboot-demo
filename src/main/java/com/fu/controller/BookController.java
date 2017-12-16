package com.fu.controller;

import com.fu.pojo.Book;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by fu on 2017/12/9.
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * 书单列表
     *
     * @param model
     * @return
     */
    @GetMapping("/books")
    public String list(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
//        List<Book> bookList = bookService.findAll();
//        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Page<Book> page1 = bookService.findAllByPage(pageable);
        model.addAttribute("page", page1);
        return "books";
    }

    /**
     * 书单详情
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/books/{id}")
    public String detail(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        if (null == book) {
            book = new Book();
        }
        model.addAttribute("book", book);
        return "book";
    }

    /**
     * 跳转input提交页面
     *
     * @return
     */
    @GetMapping("/books/input")
    public String inputPage(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "input";
    }

    /**
     * 跳转到更新页面input
     * @param id
     * @param model
     * @return
     */
    @GetMapping("books/input/{id}")
    public String inputEditPage(@PathVariable long id, Model model) {
        Book book = bookService.findOne(id);
        model.addAttribute("book", book);
        return "input";
    }

    /**
     * 提交一个书单信息
     */
    @PostMapping("/books")
    public String post(Book book, final RedirectAttributes attributes) {
        Book book1 = bookService.save(book);
        if(book1 != null){
            attributes.addFlashAttribute("message","《"+book1.getName()+"》 信息提交成功");
        }
        return "redirect:/books";
    }
}
