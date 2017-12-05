package com.fu.service;

import com.fu.pojo.Book;

import java.util.List;

/**
 * Created by fu on 2017/12/5.
 */

public interface BookService {

    //查询所有书单列表
    public List<Book> findAll();

    //提交书单（新增或更新）
    public Book save(Book book);

    //获取一条书单
    public Book findOne(long id);

    //删除一条
    public void deleteOne(long id);
}
