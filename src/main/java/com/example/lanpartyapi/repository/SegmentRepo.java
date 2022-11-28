package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SegmentRepo extends JpaRepository<Segment, Integer> {

    List<Segment> findSegmentsBytableplan_id(int tableplan_id);
}
