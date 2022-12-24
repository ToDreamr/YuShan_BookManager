package com.book.service.impl;

import com.book.dao.UserMapper;
import com.book.entity.User;
import com.book.service.UserService;
import com.book.util.SqlUtils;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/9 9:08
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean isLogin(String username, String password, HttpSession session) {
        try (SqlSession sqlSession=SqlUtils.getSqlSession()){
            UserMapper mapper=sqlSession.getMapper(UserMapper.class);
            User user=mapper.getUser(username,password);
            if(user==null) {
                return false;
            }
            //让session来携带用户信息
            session.setAttribute("user",user);
            return true;
        }
    }
}
