package com.book.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/9 8:55
 */
public class SqlUtils {
    private static SqlSessionFactory factory=null;
    //静态代码块在类加载的时候就加载
    static {
     try {
         factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

    public  SqlUtils()  {
    }
    public static SqlSession getSqlSession(){
     return factory.openSession(true);
    }
}
