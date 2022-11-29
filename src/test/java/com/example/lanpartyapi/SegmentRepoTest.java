package com.example.lanpartyapi;

import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class SegmentRepoTest {

    @Autowired
    SegmentRepo segmentRepo;
    @Autowired
    TablePlanRepo tablePlanRepo;

    @BeforeEach
    void setUpSegment() {
        Segment newSegment = new Segment();
        Segment newSegment2 = new Segment();
        Segment newSegment3 = new Segment();

        List<Segment> segments = new ArrayList<>();

        segments.add(newSegment);
        segments.add(newSegment2);
        segments.add(newSegment3);

        for (int i = 0; i < segments.size(); i++) {
            segmentRepo.save(segments.get(i));

        }
        TablePlan tablePlan = new TablePlan();
        tablePlan.setName("Bord1");


        tablePlanRepo.save(tablePlan);
    }

    @Test
    void addSegmentToTablePlan() {
        TablePlan myTablePlan = tablePlanRepo.findByName("Bord1").get();
        List<Segment> segmentsAfter = new ArrayList<>(segmentRepo.findAll());
        myTablePlan.setSegments(segmentsAfter);

        assertEquals(3, myTablePlan.getSegments().size());
    }

    @Test
    void removeSegmentsFromTablePlan() { //TODO Tænker denne test skal køres igennem Service klassen

        // TablePlan myTablePlan = tablePlanRepo.findByName("Bord1");

        //myTablePlan.


    }


}