package com.example.guessinggame.services;

import com.example.guessinggame.dto.request.PlayerRequest;
import com.example.guessinggame.dto.response.PlayerResponse;
import com.example.guessinggame.exceptions.FindingException;
import com.example.guessinggame.exceptions.InvalidAgeException;
import com.example.guessinggame.exceptions.WrongInputException;
import com.example.guessinggame.model.Player;
import com.example.guessinggame.repositories.PlayerInterface;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class PlayerService implements PlayerServicesInterface{
    @NonNull
    private final PlayerInterface playerInterface;
    @Override
    public PlayerResponse registerPlayer(PlayerRequest playerRequest1) {
        emailAlreadyExistChecking(playerRequest1.getEmail());
        Player player = mapPlayerRequestToEntity(playerRequest1);
        if (player.getYearOfBirth().length()!=4)throw new WrongInputException("year should have a length of four");
        if (ageCalculator(player.getYearOfBirth())<18) throw new InvalidAgeException("you are under aged for this game");
        player.setAge(String.valueOf(ageCalculator(player.getYearOfBirth())));
        return mapPlayerToResponse(playerInterface.save(player));
    }

    private void emailAlreadyExistChecking(String email) {
        Player foundPlayer = playerInterface.findByEmail(email);
        if (foundPlayer != null) throw new FindingException("account with the email "+email+" already exist");
    }

    @Override
    public PlayerResponse findPlayerByEmail(String email) {
        Player foundPlayer = playerInterface.findByEmail(email);
        if (foundPlayer == null) throw new FindingException("account with the email "+email+" does not exist");
        return mapPlayerToResponse(foundPlayer);
    }

    @Override
    public void deleteAll() {
        playerInterface.deleteAll();
    }

    @Override
    public long CountAllPlayer() {
        return playerInterface.count();
    }

    @Override
    public void deleteByEmail(String email) {
        PlayerResponse foundPlayer = findPlayerByEmail(email);
        playerInterface.deleteByEmail(email);
    }

    public Player mapPlayerRequestToEntity(PlayerRequest playerRequest){
        return Player.builder()
                .yearOfBirth(playerRequest.getYearOfBirth())
                .email(playerRequest.getEmail())
                .id(playerRequest.getId())
                .phoneNumber(playerRequest.getPhoneNumber())
                .password(playerRequest.getPassword())
                .userName(playerRequest.getUserName())
                .build();
    }
    public PlayerResponse mapPlayerToResponse(Player player){
        return PlayerResponse.builder()
                .age(player.getAge())
                .balance(player.getBalance())
                .loggedIn(player.isLoggedIn())
                .phoneNumber(player.getPhoneNumber())
                .yearOfBirth(player.getYearOfBirth())
                .build();
    }
    public int ageCalculator(String yearOfBirth){
        for (int i = 0; i < yearOfBirth.length(); i++) {
            if (Character.isAlphabetic(yearOfBirth.charAt(i)))throw new WrongInputException("you have entered an invalid input");
        }
        return  LocalDateTime.now().getYear() - Integer.parseInt(yearOfBirth);
    }


}
