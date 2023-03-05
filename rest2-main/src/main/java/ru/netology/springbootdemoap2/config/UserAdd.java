package ru.netology.springbootdemoap2.config;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemoap2.UserModel.Authorities;
import ru.netology.springbootdemoap2.UserModel.User;
import ru.netology.springbootdemoap2.repository.UserRepository;


import java.util.Arrays;


import static java.rmi.server.LogStream.log;


@Configuration
public class UserAdd {

    private static final Logger log = (Logger) LoggerFactory.getLogger(UserAdd.class);

    @Bean
    public CommandLineRunner initUsers(UserRepository repository) {
        return args -> {
            log("Preloading " + repository.save(new User("Dima", "123", Arrays.asList(Authorities.values()))));
            log("Preloading " + repository.save(new User("Mit", "321", Arrays.asList(Authorities.READ, Authorities.WRITE))));
        };
    }
}