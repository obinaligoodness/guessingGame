package com.example.guessinggame.dto.response;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class PlayerResponse {
    private double balance;
    private String age;
    private String yearOfBirth;
    private String userName;
    private String phoneNumber;
    private boolean loggedIn;
}
