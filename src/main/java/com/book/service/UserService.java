package com.book.service;

import com.mysql.cj.Session;
import jakarta.servlet.http.HttpSession;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/9 9:06
 */
public interface UserService {
    //只负责判断是否进行了登录
    boolean isLogin(String username, String password, HttpSession session);
}
