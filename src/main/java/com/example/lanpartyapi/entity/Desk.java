package com.example.lanpartyapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int desk_id;

    @OneToMany(mappedBy = "desk", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Chair> chairs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segment_id")
    private Segment segment;


}
