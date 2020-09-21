package com.guigu.dao.impl;

import com.guigu.dao.BookDao;
import com.guigu.pojo.Book;

import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/12
 */
public class   BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {

        String sql="insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";

        return  update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql="delete from t_book where id=?";

        return update(sql,id);
    }

    @Override
    public int updateBookById(Book book) {
        String sql="update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id)
    {
        String sql ="select `id`, `name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book where id=?";

        return queryForOne(Book.class,sql,id);

    }


    @Override
    public List<Book> queryBooks() {
        String sql="select `id`, `name`,`author`,`price`,`sales`,`stock`,`img_path` from t_book";
        return queryForList(Book.class,sql);
    }
}
