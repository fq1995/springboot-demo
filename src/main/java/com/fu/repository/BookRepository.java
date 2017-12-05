package com.fu.repository;

import com.fu.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fu on 2017/12/5.
 */
public interface BookRepository extends JpaRepository<Book, Long> {


}
