package com.example.lanpartyapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class LanUserRequest {

    private String username;
    private String password;
}
