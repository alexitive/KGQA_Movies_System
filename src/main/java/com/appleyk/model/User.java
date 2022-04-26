package com.appleyk.model;

import org.apache.arrow.flatbuf.Binary;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class User {

    private int id; // 限制长度8
    private  String name; // 限制长度255
    private String password; // 限制长度255
    private int authority;
    private String comment; // 限制长度255

    public User(){}

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String commment) {
        this.name = name;
        this.password = password;
        this.comment = commment;
    }

    public User(int uid, String name, String password, int authority, String commment) {
        this.id = uid;
        this.name = name;
        this.password = password;
        this.authority = authority;
        this.comment = commment;
    }

    public int getUid() {
        return id;
    }

    public void setUid(int uid) {
        this.id = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAuthority() {
        return authority;
    }

    public void setAuthority(int authority) {
        this.authority = authority;
    }

    public String getCommment() {
        return comment;
    }

    public void setCommment(String commment) {
        this.comment = commment;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", authority=" + authority +
                ", commment='" + comment + '\'' +
                '}';
    }
}
