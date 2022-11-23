package com.example.lanpartyapi.entity;

import javax.persistence.CascadeType;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Segment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int segment_id;

    @OneToMany(mappedBy = "segment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Desk> desks = new ArrayList<>();


    @JoinColumn(name = "tableplan_id")
    @ManyToOne(fetch = FetchType.LAZY)
    TablePlan tablePlan;



}
