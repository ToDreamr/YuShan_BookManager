package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/9 9:42
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    BookService service;
    @Override
    public void init() throws ServletException {
        service= new BookServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context context=new Context();
        User user= (User) req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("borrow_list",service.getBorrowList());
        context.setVariable("student_count", service.getStudentList().size());
        context.setVariable("book_count", service.getStudentList().size());
        //显然借阅数据量和借阅学生的多少应该是他们的列表大小
        ThymeleafUtil.process("index.html",context, resp.getWriter());
    }
}
