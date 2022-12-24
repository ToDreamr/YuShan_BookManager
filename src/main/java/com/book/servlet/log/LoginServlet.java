package com.book.servlet.log;

import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.util.ThymeleafUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/7 16:25
 */
@WebServlet("/login")
//继承Servlet

public class LoginServlet extends HttpServlet {
    UserService service;
    @Override
    public void init() throws ServletException {
        service=new UserServiceImpl();
    }

    //百里香叶自动加载页面信息
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Context context=new Context();

       Cookie []cookies= req.getCookies();
       if(cookies!=null){
           String username=null;
           String password=null;
           for (Cookie cookie:cookies) {
               if (cookie.getName().equals("username")) username=cookie.getValue();
               if(cookie.getName().equals("password")) password=cookie.getValue();
           }
           if (username!=null&&password!=null){
               if (service.isLogin(username,password, req.getSession())){
                   resp.sendRedirect("index");
                   return;
               }
           }
       }
       if (req.getSession().getAttribute("Login-failure")!=null){
           context.setVariable("failure",true);
           req.getSession().removeAttribute("Login-failure");
       }
       if (req.getSession().getAttribute("user")!=null){
           resp.sendRedirect("index");
           return;
       }
        ThymeleafUtil.process("login.html",context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String remember=req.getParameter("remember-me");

        if(service.isLogin(username,password, req.getSession())){
            if (remember!=null){
                Cookie cookie_username=new Cookie("username",username);
                Cookie cookie_password=new Cookie("password",password);
                cookie_username.setMaxAge(60 * 60 * 24 * 7);
                cookie_password.setMaxAge(60 * 60 * 24 * 7);
                resp.addCookie(cookie_username);
                resp.addCookie(cookie_password);
            }
            resp.sendRedirect("index");
        }else {
            req.getSession().setAttribute("Login-failure",new Object());
            this.doGet(req,resp);
        }
    }
}
