package com.example.lanpartyapi.api;

import com.example.lanpartyapi.dto.LanUserRequest;
import com.example.lanpartyapi.service.RegisterService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/register")
public class RegisterController {

    RegisterService registerService;

    RegisterController(RegisterService registerService){
        this.registerService = registerService;
    }

    @PostMapping()
    public void registerUser(@RequestBody LanUserRequest body){
        this.registerService.saveLanUser(body);
    }

}
