package com.example.lanpartyapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Reservation {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "lan_user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private LanUser lanUser;

    public String getOwnerUsername() {
        String username = "";
        if (this.lanUser != null) {
            username = this.lanUser.getLanUserName();
        }

        return username;
    }
}
