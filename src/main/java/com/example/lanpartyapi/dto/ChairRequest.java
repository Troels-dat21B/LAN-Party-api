package com.example.lanpartyapi.dto;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChairRequest {
    int id;
    Desk desk;
    boolean is_reserved;

    public static Chair getChairEntity(ChairRequest c){
        return new Chair(c.getId(), c.getDesk(), c.is_reserved());
    }

    public ChairRequest(Chair c){
        this.id = c.getChair_id();
        this.desk = c.getDesk();
        this.is_reserved = c.is_reserved();
    }
}
