package com.example.lanpartyapi.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ReservationRequest {

    private List<Integer> chairIds;
}
