package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ChairRepoTest {

    private static ChairRepo chairRepo;
    private static DeskRepo deskRepo;
    private static SegmentRepo segmentRepo;
    private static TablePlanRepo tablePlanRepo;

    private static int segment1Id;
    private static int segment2Id;

    @BeforeAll
    static void setup(
            @Autowired ChairRepo chairRepository,
            @Autowired DeskRepo deskRepository,
            @Autowired SegmentRepo segmentRepository,
            @Autowired TablePlanRepo tablePlanRepository
    ) {
        chairRepo = chairRepository;
        deskRepo = deskRepository;
        segmentRepo = segmentRepository;
        tablePlanRepo = tablePlanRepository;

        var tablePlan = new TablePlan();

        var segment1 = new Segment();
        segment1.setTableplan(tablePlan);
        var segment2 = new Segment();
        segment2.setTableplan(tablePlan);

        var table1 = new Desk();
        table1.setSegment(segment1);
        var table2 = new Desk();
        table2.setSegment(segment1);
        var table3 = new Desk();
        table3.setSegment(segment2);
        var table4 = new Desk();
        table4.setSegment(segment2);

        var chair1 = new Chair();
        chair1.setDesk(table1);
        var chair2 = new Chair();
        chair2.setDesk(table1);
        var chair3 = new Chair();
        chair3.setDesk(table2);
        var chair4 = new Chair();
        chair4.setDesk(table2);
        var chair5 = new Chair();
        chair5.setDesk(table3);
        var chair6 = new Chair();
        chair6.setDesk(table3);
        var chair7 = new Chair();
        chair7.setDesk(table4);
        var chair8 = new Chair();
        chair8.setDesk(table4);

        tablePlan = tablePlanRepo.save(tablePlan);

        segment1 = segmentRepo.save(segment1);
        segment2 = segmentRepo.save(segment2);

        segment1Id = segment1.getSegment_id();
        segment2Id = segment2.getSegment_id();

        table1 = deskRepo.save(table1);
        table2 = deskRepo.save(table2);
        table3 = deskRepo.save(table3);
        table4 = deskRepo.save(table4);

        chair1 = chairRepo.save(chair1);
        chair2 = chairRepo.save(chair2);
        chair3 = chairRepo.save(chair3);
        chair4 = chairRepo.save(chair4);
        chair5 = chairRepo.save(chair5);
        chair6 = chairRepo.save(chair6);
        chair7 = chairRepo.save(chair7);
        chair8 = chairRepo.save(chair8);
    }

    @Test
    void findBySegment() {
        //Test will fail without the statement below
        chairRepo.findAll();

        var chairsBySegment1 = chairRepo.findBySegment(segment1Id);
        var chairsBySegment2 = chairRepo.findBySegment(segment2Id);

        assertNotEquals(0, chairsBySegment1.size());
        assertNotEquals(0, chairsBySegment2.size());

        chairsBySegment1.forEach(chair -> {
            var deskOptional = deskRepo.findById(chair.getDesk().getDesk_id());
            var desk = deskOptional.orElseThrow();

            assertEquals(segment1Id, desk.getSegment().getSegment_id());
        });

        chairsBySegment2.forEach(chair -> {
            var deskOptional = deskRepo.findById(chair.getDeskId());
            var desk = deskOptional.orElseThrow();

            assertEquals(segment2Id, desk.getSegmentId());
        });
    }
}