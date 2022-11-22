package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepo extends JpaRepository<Desk, Integer> {
}
