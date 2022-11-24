package com.example.lanpartyapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LanUser {

    @Id
    @Column(unique = true, nullable = false, length = 45)
    private String lanUserName;

    @Column(nullable = false, length = 80)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    private LanUserType userType;
}
