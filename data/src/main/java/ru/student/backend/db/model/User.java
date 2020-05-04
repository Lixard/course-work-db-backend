package ru.student.backend.db.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int userId;
    private String username;
    private String password;
    //TODO поменять на Role enum в будущем
    private int role;
}
