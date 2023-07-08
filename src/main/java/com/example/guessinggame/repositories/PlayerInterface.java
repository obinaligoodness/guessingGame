package com.example.guessinggame.repositories;

import com.example.guessinggame.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerInterface extends MongoRepository<Player,String> {

    Player findByEmail(String email);

    void deleteByEmail(String email);
}
