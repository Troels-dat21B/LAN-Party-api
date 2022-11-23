package com.example.lanpartyapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Chair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int chair_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "desk_id")
    private Desk desk;

    private boolean is_reserved = false;

    public void addDesk(Desk desk){
        this.desk = desk;
    }


}
