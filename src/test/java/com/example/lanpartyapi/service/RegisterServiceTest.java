package com.example.lanpartyapi.service;

import com.example.lanpartyapi.dto.LanUserRequest;
import com.example.lanpartyapi.entity.LanUser;
import com.example.lanpartyapi.entity.LanUserType;
import com.example.lanpartyapi.repository.LanUserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@DataJpaTest
public class RegisterServiceTest {


    static LanUserRepository lanUserRepositoryStatic;

    @BeforeAll
    public static void setUp(@Autowired LanUserRepository lanUserRepository) {
        lanUserRepositoryStatic = lanUserRepository;
        LanUser user = new LanUser();
        user.setLanUserName("test");
        user.setUserPassword("123");
        user.setUserType(LanUserType.USER);
        lanUserRepository.save(user);
    }

  /*  @Test
    public void saveLanUserTest() {

        Optional<LanUser> test = lanUserRepositoryStatic.findById("test");

        if (test.isPresent()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Name already taken!");
        } else {
            // String name = body.getUsername();
            //String password = body.getPassword();

            LanUser newUser = new LanUser();
           *//* newUser.setLanUserName(name);
            newUser.setUserPassword(password);*//*
            newUser.setUserType(LanUserType.USER);

            lanUserRepositoryStatic.save(newUser);
        }

    }*/
}