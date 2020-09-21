package com.guigu.web;

import com.guigu.pojo.Book;
import com.guigu.service.BookService;
import com.guigu.service.impl.BookServiceImpl;
import com.guigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * TODO
 *
 * @author Administrator
 * @date 2020/9/13
 */
public class BookServlet extends BaseServlet {

    private BookService bookService=new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数 ==封装成BOOK对象

        Book book =WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2.调用BookService.addBook(book)保存图书

        bookService.addBook(book);
        //3.转跳页面到图书列表页面

       // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //1.获取请求参数id,图书编程
     int id=WebUtils.parseInt(req.getParameter("id"),0);

   //2.调用bookservice.deleteBookById()删除图书

        bookService.deleteBookById(id);

   //3.重定向回到图书列表管理页面

    resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数--封装成Book对象

        //2.调用BookService.updateBook(book);

        //3.重定向回图书列表管理页面
        //地址：/工程名/manager/bookServlet?action=list



    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取图书编号
         int id =WebUtils.parseInt(req.getParameter("id"),0);

        //2.调用bookservice.queryBookById(id):Book:得到修改的的图书信息。
            Book book =bookService.queryBookById(id);
           //3.把图书保存到Requtest域中
                req.setAttribute("book",book);
        //4.请求转发到/pages/manager/book_edit.jsp
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService查询全部图书
        List<Book> books = bookService.queryBooks();
        //2。把全部图书保存到request域中

        req.setAttribute("books",books);


        //3.请求转发到/pages/manager/book_manager.jsp

     req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

        // req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);


    }
}

