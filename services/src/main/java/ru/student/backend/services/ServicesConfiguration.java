package ru.student.backend.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.student.backend.db.DataConfiguration;


@Configuration
@ComponentScan
@Import(DataConfiguration.class)
public class ServicesConfiguration {
}
