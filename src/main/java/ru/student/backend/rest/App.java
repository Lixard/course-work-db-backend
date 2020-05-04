package ru.student.backend.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.student.backend.security.SecurityConfiguration;
import ru.student.backend.services.ServicesConfiguration;

@SpringBootApplication
@Import({
        ServicesConfiguration.class,
        SecurityConfiguration.class
})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
