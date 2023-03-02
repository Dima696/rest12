package ru.netology.springbootdemoap2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemoap2.Authorities;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Optional.ofNullable;

@Repository
public class UserRepository {

    private final Map<Integer, List<Authorities>> storage = new ConcurrentHashMap<>();

    public void save (String user, String password, List <Authorities> authorities) {
        storage.put(getKey(user, password), authorities);
    }

    private int getKey(String user, String password) {
        return Objects.hash (user, password);
    }

    public List <Authorities> getUserAuthorities(String user, String password) {
        return ofNullable(storage.get(getKey(user, password)))
                .orElseGet(Collections::emptyList);
    }

}