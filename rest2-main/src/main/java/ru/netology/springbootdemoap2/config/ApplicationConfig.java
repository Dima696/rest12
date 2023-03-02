package ru.netology.springbootdemoap2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemoap2.repository.UserRepository;

import java.util.List;

import static ru.netology.springbootdemoap2.Authorities.*;

@Configuration
    public class ApplicationConfig {

        @Bean
        public UserRepository userRepositoryStub() {
            final var repo = new UserRepository();
            repo.save("user", "1234", List.of(READ));
            repo.save("manager", "1234", List.of(READ, WRITE));
            repo.save("admin", "1234", List.of(READ, WRITE, DELETE));
            return repo;
        }

    }
