package com.appleyk.result;

import com.appleyk.model.User;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


@Component
@Data
public class LoginResponse {

    int token;

    User user;

//    public LoginResponse() {
//
//    }
//
//    public void setToken(int token) {
//        this.token = token;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @JsonIgnore
    @Override
    public String toString() {
        return "LoginResponse{" +
                "token=" + token +
                ", user=" + (user != null ? user.toString() : "") +
                '}';
    }
}
