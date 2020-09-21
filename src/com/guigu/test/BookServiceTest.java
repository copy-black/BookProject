package com.guigu.test;

import com.guigu.dao.BookDao;
import com.guigu.dao.impl.BookDaoImpl;
import com.guigu.pojo.Book;
import com.guigu.service.BookService;
import com.guigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/13
 */
public class BookServiceTest {
    private BookService bookService =new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"1908","我很帅",new BigDecimal(999),10000,0,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(26);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(26,"八英里","艾米纳姆",new BigDecimal(1000),232321,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(26));;
    }

    @Test
    public void queryBooks() {
        for (Book query:bookService.queryBooks()) {
            System.out.println(query);
        }
    }
}