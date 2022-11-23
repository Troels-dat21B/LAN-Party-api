package com.example.lanpartyapi.api;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Cookie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/login")
public class  LoginController {
    
    @GetMapping()
    public ResponseEntity<String> cookieTest (HttpServletResponse httpServletResponse){
        

        return new ResponseEntity<>("Succesfully received cookie", HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> cookieReceivedTest (@CookieValue("testCookie") String test){
        return new ResponseEntity<>(test, HttpStatus.OK);
    }
}
