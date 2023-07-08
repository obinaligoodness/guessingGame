package com.example.guessinggame.services;

import com.example.guessinggame.dto.request.Goat;
import com.example.guessinggame.dto.request.PlayerRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

class PlayerServicesInterfaceTest {
private PlayerRequest playerRequest1;
private PlayerRequest playerRequest2;
@Autowired
private  PlayerServicesInterface playerServices;


    @BeforeEach
    void setUp() {
        playerRequest1 = new PlayerRequest();
        playerRequest1.setEmail("obinaligoodness@gmail.com");
        playerRequest1.setPassword("good123#");
        playerRequest1.setUserName("goodness");
        playerRequest1.setPhoneNumber("08031286941");
        playerRequest1.setYearOfBirth("2001");
        playerRequest2 = new PlayerRequest();
        playerRequest2.setEmail("goodnessobinali@gmail.com");
        playerRequest2.setPassword("bood123");
        playerRequest2.setUserName("obinali");
        playerRequest2.setPhoneNumber("08133571570");
        playerRequest2.setYearOfBirth("2000");
    }
    @Disabled
    @Test
    void testThatPlayerCanRegister(){
        assertNotNull(playerServices.registerPlayer(playerRequest1));
        assertNotNull(playerServices.registerPlayer(playerRequest2));
    }
    @Test
    public void testThatPlayerCanBeFoundByEmail(){
        assertEquals("22",playerServices.findPlayerByEmail("obinaligoodness@gmail.com").getAge());
    }
    @Disabled
    @Test
    void testThatWeCanDeleteAllPlayerAccount(){
        playerServices.deleteAll();
        assertEquals(0,playerServices.CountAllPlayer());
    }
    @Test
    void testThatWeCanDeleteByEmail(){
        assertDoesNotThrow(()->{playerServices.deleteByEmail("obinaligoodness@gmail.com");});
    }
}