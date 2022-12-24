package com.book.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Rainy-Heights
 * @version 1.0
 * @Date 2022/11/7 17:19
 */
@Data
public class User {
    int id;
    String username;
    String password;
    String nickname;

    public User(String username, String password, String nickname) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
    }
}
