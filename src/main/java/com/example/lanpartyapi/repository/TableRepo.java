package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TableRepo extends JpaRepository<Table, Integer> {
}
