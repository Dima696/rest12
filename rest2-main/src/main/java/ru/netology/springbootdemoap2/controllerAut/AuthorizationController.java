package ru.netology.springbootdemoap2.controllerAut;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.springbootdemoap2.UserModel.Authorities;
import ru.netology.springbootdemoap2.UserModel.User;
import ru.netology.springbootdemoap2.UserAnnotation;
import ru.netology.springbootdemoap2.service.AuthorizationService;

import java.util.List;

@RestController
@Valid
public class AuthorizationController {
    private final AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }


    @GetMapping("/authorize")
    public ResponseEntity<List<Authorities>> getAuthorities(@Valid @UserAnnotation User user) {
        return ResponseEntity.ok(service.getAuthorities(user));
    }
}
