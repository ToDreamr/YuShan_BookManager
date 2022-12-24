package com.book.servlet.pages;

import com.book.dao.BookMapper;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.util.SqlUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.java.Log;


import java.io.IOException;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/15 14:48
 */
@WebServlet("/return-book")
@Log
public class ReturnServlet extends HttpServlet {
    //先声明service参数，再通过控制层来实例化参数
    BookService service;
    @Override
    public void init() throws ServletException {
        service=new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //需要请求归还参数，首先获取归还学生ID
        int Id= Integer.parseInt(req.getParameter("id"));
        /*相关于归还图书代码和更新数据库的逻辑

        * */
        service.returnBook(String.valueOf(Id));
        log.info("删除了一本书");
        resp.sendRedirect("index");
    }
}
