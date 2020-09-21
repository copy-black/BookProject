package com.guigu.test;

import com.alibaba.druid.sql.visitor.functions.Bin;
import com.guigu.dao.BookDao;
import com.guigu.dao.impl.BookDaoImpl;
import com.guigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12
 */
public class BookDaoTest {

    private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"1906","雷浩呀",new BigDecimal(999),10000,0,null));
    }

    @Test
    public void deleteBookById() {
      // bookDao.deleteBookById(23);
    }

    @Test
    public void updateBookById() {
        bookDao.updateBookById(new Book(24,"八英里","艾米纳姆",new BigDecimal(1000),11111,0,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(24)
        );
    }

    @Test
    public void queryBooks() {
        for (Book querybook:bookDao.queryBooks()) {
            System.out.println(querybook);
        }
    }
}