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
public class LoginController {
    
    @GetMapping()
    public ResponseEntity<String> cookieTest (HttpServletResponse httpServletResponse){
        Cookie cookie = new Cookie("testCookie", "test");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(60*60);
        cookie.setPath("/");

        httpServletResponse.addCookie(cookie);

        return new ResponseEntity<>("Succesfully received cookie", HttpStatus.OK);
    }
    
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("test", HttpStatus.OK);
    }

}
