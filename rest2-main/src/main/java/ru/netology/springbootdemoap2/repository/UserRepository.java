package ru.netology.springbootdemoap2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemoap2.UserModel.Authorities;
import ru.netology.springbootdemoap2.UserModel.User;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

    private final List<User> users = new CopyOnWriteArrayList<>();

    public List<Authorities> getUserAuthorities(User user) {
        int userIndex = users.indexOf(user);
        return userIndex != -1 ? users.get(userIndex).getAuthorities() : Collections.emptyList();
    }

    public String save(User user) {
        users.add(user);
        return user.getUser();
    }
}
