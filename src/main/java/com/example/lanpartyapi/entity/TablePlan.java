package com.example.lanpartyapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@OneToMany
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TablePlan {


    @Id
    int id;
}
