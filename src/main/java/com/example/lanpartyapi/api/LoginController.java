package com.example.lanpartyapi.api;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class  LoginController {
    
    @GetMapping()
    public ResponseEntity<String> cookieTest (HttpServletResponse httpServletResponse){
        

        return new ResponseEntity<>("Succesfully received cookie", HttpStatus.OK);
    }

}
