package com.example.lanpartyapi.dto;

import com.example.lanpartyapi.entity.Chair;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChairResponse {

    int chair_id;
    int desk_id;
    boolean is_reserved;

   public ChairResponse(Chair c){
        this.chair_id = c.getChair_id();
        this.desk_id = c.getDesk().getDesk_id();
        this.is_reserved = c.is_reserved();
    }

}
