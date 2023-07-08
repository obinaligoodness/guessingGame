package com.example.guessinggame.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data


public class PlayerRequest {
        private String yearOfBirth;
        private String age;
        private String userName;
        private String email;
        private String id;
        private String phoneNumber;
        private boolean loggedIn;
        private String password;
}
