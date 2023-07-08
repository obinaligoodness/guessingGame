package com.example.guessinggame.controller;

import com.example.guessinggame.dto.request.PlayerRequest;
import com.example.guessinggame.services.PlayerService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/player/")
@RequiredArgsConstructor
public class PlayerController {
    @NonNull
    private final PlayerService playerService;

    @PostMapping("register")
    public ResponseEntity<?> registerPlayer(PlayerRequest playerRequest){
        return new ResponseEntity<>(playerService.registerPlayer(playerRequest), HttpStatus.CREATED);
    }
    @PostMapping("find/")
    public ResponseEntity<?> findPlayerByEmail(String email){
        return new ResponseEntity<>(playerService.findPlayerByEmail(email),HttpStatus.FOUND);
    }
}
