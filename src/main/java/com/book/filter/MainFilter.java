package com.book.filter;

import com.book.entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/7 17:16
 */
//没有登录之前需要拦截所有页面请求

@WebFilter("/index")
public class MainFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        res.sendRedirect("register");
//        if(req.getParameter("click")!=null){
//            //将请求获取的url转换为字符串
//            String url=req.getRequestURI().toString();
//            if(!url.contains("/static/")&&!url.endsWith("login")) {
//                HttpSession session= req.getSession();
//                User user=(User)session.getAttribute("user");
//                if (user==null){
//                    res.sendRedirect("login");
//                    return;
//                }
//                chain.doFilter(req,res);
//            }
//        }
        String url = req.getRequestURL().toString();
        HttpSession session = req.getSession();
        User user  = (User) session.getAttribute("user");
        if(user!=null){
            chain.doFilter(req,res);
        }else{
            //没有登录
            //拦截下来，跳转到登录页面，并显示未登录的信息
            req.getRequestDispatcher("/login").forward(req,res);
        }

   }
}
