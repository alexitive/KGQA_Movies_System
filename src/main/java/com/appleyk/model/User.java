package com.appleyk.model;

import lombok.Data;
import org.apache.arrow.flatbuf.Binary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class User {

    private int id; // 限制长度8
    private  String name; // 限制长度255
    private String password; // 限制长度255
    private int authority;
    private String comment; // 限制长度255

    public User(){}

    public User(String name, String password, String comment) {
        this.name = name;
        this.password = password;
        this.comment = comment;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public User(int id, String name, String password, int authority) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
    }

    public User(int id, String name, String password, int authority, String comment) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                ", comment='" + comment + '\'' +
                '}';
    }
}
