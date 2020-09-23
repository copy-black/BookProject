package com.guigu.service.impl;

import com.guigu.dao.BookDao;
import com.guigu.dao.impl.BaseDao;
import com.guigu.dao.impl.BookDaoImpl;
import com.guigu.pojo.Book;
import com.guigu.pojo.Page;
import com.guigu.service.BookService;

import java.security.PrivateKey;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/13
 */
public class BookServiceImpl  implements BookService {

    private BookDao bookDao=new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {

        bookDao.updateBookById(book);
    }

    @Override
    public Book queryBookById(Integer id) {

        return    bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {

        return  bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNO, int pageSize) {

        return null;
    }
}
