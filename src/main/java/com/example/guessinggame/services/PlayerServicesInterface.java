package com.example.guessinggame.services;

import com.example.guessinggame.dto.request.PlayerRequest;
import com.example.guessinggame.dto.response.PlayerResponse;
import com.example.guessinggame.model.Player;


public interface PlayerServicesInterface {

    PlayerResponse registerPlayer(PlayerRequest playerRequest1);

    PlayerResponse findPlayerByEmail(String email);

     void deleteAll();

    long CountAllPlayer();

    void deleteByEmail(String s);
}
