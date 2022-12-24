package com.book.test;

import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/16 12:55
 */
public class Test extends HttpServlet {
    BookService service;
    @Override
    public void init() throws ServletException {
        service=new BookServiceImpl();
    }
    public static void main(String[] args) {
        Test test=new Test();

    }

}
