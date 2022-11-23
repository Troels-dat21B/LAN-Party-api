package com.example.lanpartyapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class TablePlan {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int tableplan_id;

    @OneToMany
    public List<Segment> segments = new ArrayList<>();


    private String name;


}
