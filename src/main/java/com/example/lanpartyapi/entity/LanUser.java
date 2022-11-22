package com.example.lanpartyapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class LanUser {

    @Id
    @Column(unique = true, nullable = false, length = 45)
    private String userUsername;

    @Column(nullable = false, length = 80)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private LanUserType userType;
}
