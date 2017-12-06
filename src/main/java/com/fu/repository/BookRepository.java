package com.fu.repository;

import com.fu.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    //根据作者查找
    List<Book> findByAuthor(String author);

    //根据作者和状态查询
    List<Book> findByAuthorAndStatus(String author, int status);

}
