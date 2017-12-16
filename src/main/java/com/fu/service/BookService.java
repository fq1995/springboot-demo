package com.fu.service;

import com.fu.pojo.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */

public interface BookService {

    //查询所有书单列表
    public List<Book> findAll();

    //分页查询
    public Page<Book> findAllByPage();

    //分页查询
    public Page<Book> findAllByPage(Pageable pageable);

    //提交书单（新增或更新）
    public Book save(Book book);

    //获取一条书单
    public Book findOne(long id);

    //删除一条
    public void deleteOne(long id);

    //根据作者查询
    public List<Book> findByAuthor(String author);

    //根据作者和状态查询
    public List<Book> findByAuthorAndStatus(String author, int status);

    //根据描述模糊查询
    public List<Book> findByDescriptionContains(String des);

    //自定义JPQL查询
    public List<Book> findByJPQL(int len);

    //自定义sql查询
    public List<Book> findBySQL(int len);

    //自定义JPQL更新
    @Transactional
    public int updateByJPQL(int status, long id);

    //自定义删除
    @Transactional
    public int deleteByJPQL(long id);
}
