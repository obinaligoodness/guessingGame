package com.example.guessinggame.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@Builder
public class Player {
    private double balance;
    private String age;
    private String yearOfBirth;
    private String userName;
    private String email;
    private String id;
    private String phoneNumber;
    private boolean loggedIn;
    private String password;
}
