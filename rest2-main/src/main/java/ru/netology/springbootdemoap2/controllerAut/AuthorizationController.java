package ru.netology.springbootdemoap2.controllerAut;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.netology.springbootdemoap2.UserModel.Authorities;
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
    public List<Authorities> getAuthorities(@RequestParam String user, @RequestParam String password) {
        return service.getAuthorities(user, password);

    }
}
