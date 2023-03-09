package ru.netology.springbootdemoap2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemoap2.UserModel.Authorities;
import ru.netology.springbootdemoap2.UserModel.User;
import ru.netology.springbootdemoap2.exception.InvalidCredentials;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

        private final ConcurrentHashMap<String, User> userConcurrentHashMap;

        public UserRepository() {
            this.userConcurrentHashMap = new ConcurrentHashMap<>() ;
            userConcurrentHashMap.put("Dima", new User("Dima","123", List.of(Authorities.READ)));
            userConcurrentHashMap.put("Kat", new User("Kat","321", List.of(Authorities.READ, Authorities.WRITE)));
            userConcurrentHashMap.put("Auf", new User("Auf","111", List.of()));
        }

        public List <Authorities> getUserAuthorities(String user, String password) {
            if(userConcurrentHashMap.containsKey(user)
                    && userConcurrentHashMap.get(user).getPassword().equals(password)
            ) {
                User userD = userConcurrentHashMap.get(user);
                return userD.getAuthoritiesList();
            } else {
                throw new InvalidCredentials("User name or password not vilid");
            }
        }
    }

