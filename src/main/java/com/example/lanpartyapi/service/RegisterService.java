package com.example.lanpartyapi.service;

import com.example.lanpartyapi.dto.LanUserRequest;
import com.example.lanpartyapi.entity.LanUser;
import com.example.lanpartyapi.entity.LanUserType;
import com.example.lanpartyapi.repository.LanUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class RegisterService {

    LanUserRepository lanUserRepository;


    RegisterService(LanUserRepository lanUserRepository){
        this.lanUserRepository = lanUserRepository;
    }

    public String saveLanUser(LanUserRequest body) {

       Optional<LanUser> test = lanUserRepository.findById(body.getUsername());

       if (test.isPresent()){

           return new ResponseStatusException(HttpStatus.FORBIDDEN, "Brugernavn eksistere allerede! ").getMessage();
       }else{
           String name = body.getUsername();
           var salt = BCrypt.gensalt(12);
           var passwordHash = BCrypt.hashpw(body.getPassword(), salt);

           LanUser newUser = new LanUser();
           newUser.setLanUserName(name);
           newUser.setUserPassword(passwordHash);
           newUser.setUserType(LanUserType.USER);

           lanUserRepository.save(newUser);

           return "Bruger Oprettet!";

       }
    }
}
