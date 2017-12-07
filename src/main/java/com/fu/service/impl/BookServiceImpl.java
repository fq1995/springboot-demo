package com.fu.service.impl;

import com.fu.pojo.Book;
import com.fu.repository.BookRepository;
import com.fu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {

        return bookRepository.findAll();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findOne(long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findByDescriptionContains(String des) {
        return bookRepository.findByDescriptionContains(des);
    }

    @Override
    public void deleteOne(long id) {
        bookRepository.delete(id);
    }

    @Override
    public List<Book> findByAuthorAndStatus(String author, int status) {
        return bookRepository.findByAuthorAndStatus(author, status);
    }

    @Override
    public List<Book> findByJPQL(int len) {
        return bookRepository.findByJPQL(len);
    }

    @Override
    public List<Book> findBySQL(int len) {
        return bookRepository.findByJPQL(len);
    }

    @Override
    public int updateByJPQL(int status, long id) {
        return bookRepository.updateByJPQL(status, id);
    }
}
