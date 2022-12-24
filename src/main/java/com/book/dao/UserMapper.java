package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/7 22:21
 */
public interface UserMapper {
    @Select("select * from admin where username=#{username} and password=#{password}")
    User getUser(@Param("username")String username,@Param("password")String password);

    //sql语句需要加强啊，太拉了！！！
    @Insert("insert into admin values(#{username},#{password},#{nickname})")
    int LoginUser(@Param("username") String username,@Param("password") String password,@Param("nickname") String nickname);

    @Insert("insert into user(username,password,nickname) values(#{username},#{password},#{nickname})")
    int AddUser(User user);
}
