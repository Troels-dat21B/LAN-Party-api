package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.TablePlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TablePlanRepo extends JpaRepository<TablePlan, Integer> {
    TablePlan findByName(String name);
}
