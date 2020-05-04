package ru.student.backend.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("ru.student.backend.db.mapper")
public class DataConfiguration {
}
