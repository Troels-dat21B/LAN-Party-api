package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SegmentRepo extends JpaRepository<Segment, Integer> {
}
