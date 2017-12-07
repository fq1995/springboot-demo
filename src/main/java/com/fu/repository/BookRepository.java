package com.fu.repository;

import com.fu.pojo.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    //根据作者查找
    List<Book> findByAuthor(String author);

    //根据作者和状态查询
    List<Book> findByAuthorAndStatus(String author, int status);

    //根据描述模糊查询
    List<Book> findByDescriptionContains(String des);

    //自定义JPQL查询语句
    @Query("select b from Book b where length(b.name) > ?1")
    List<Book> findByJPQL(int len);

    //自定义sql语句
    @Query(value = "select * from book where length(name)> ?1 ", nativeQuery = true)
    List<Book> findByNativeSQL(int len);

    //更新
    @Transactional
    @Modifying
    @Query("update Book b set b.status = ?1 where id = ?2")
    int updateByJPQL(int status, long id);

    //删除
    @Transactional
    @Modifying
    @Query("delete from Book b where b.id = ?1")
    int deleteBYJPQL(long id);
}
