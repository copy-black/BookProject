package com.guigu.service;

import com.guigu.pojo.Book;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/13
 */
public interface BookService {

    public void addBook(Book book);

    public void deleteBookById(Integer id );

    public void updateBook(Book book);

    public Book queryBookById(Integer id );

    public List<Book>  queryBooks();
}
