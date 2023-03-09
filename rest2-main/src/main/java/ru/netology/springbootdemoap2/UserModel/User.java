package ru.netology.springbootdemoap2.UserModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ru.netology.springbootdemoap2.UserModel.Authorities;

import java.util.Collections;
import java.util.List;


public class User {


    private final String user;


    private final String password;

    private final List<Authorities> authorities;

    public User(String user, String password) {
        this.user = user;
        this.password = password;
        this.authorities = Collections.emptyList();
    }

    public User(String user, String password, List<Authorities> authorities) {
        this.user = user;
        this.password = password;
        this.authorities = authorities;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public List<Authorities> getAuthoritiesList() {
        return authorities;
    }


}
