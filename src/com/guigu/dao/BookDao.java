package com.guigu.dao;

import com.guigu.pojo.Book;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12
 */
public interface BookDao {

    public int addBook(Book book);
    public int deleteBookById (Integer id);
    public  int updateBookById(Book book);
    public  Book queryBookById(Integer id);
    public List<Book> queryBooks();
}
