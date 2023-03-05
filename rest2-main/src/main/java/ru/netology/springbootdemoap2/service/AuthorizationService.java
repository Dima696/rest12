package ru.netology.springbootdemoap2.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootdemoap2.UserModel.Authorities;
import ru.netology.springbootdemoap2.UserModel.User;
import ru.netology.springbootdemoap2.exception.InvalidCredentials;
import ru.netology.springbootdemoap2.exception.UnauthorizedUser;
import ru.netology.springbootdemoap2.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
