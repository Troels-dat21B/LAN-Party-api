package com.example.lanpartyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.DeskRepo;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class FullRepositoryTest {
    @Autowired
    ChairRepo chairRepo;
    @Autowired
    DeskRepo deskRepo;
    @Autowired
    SegmentRepo segmentRepo;
    @Autowired
    TablePlanRepo tablePlanRepo;


    @BeforeEach
    void setupBeforeTests() {
        TablePlan tablePlan = new TablePlan();
        tablePlan.setName("Test tableplan");

        Segment segment = new Segment();
        Segment segment2 = new Segment();

        //Husk at de skal forbindes til hinanden Segment <- TablePlan
        segment.setTablePlan(tablePlan);
        segment2.setTablePlan(tablePlan);

        //Husk at de skal forbindes til hinanden Segment -> TablePlan
        tablePlan.addSegment(segment);
        tablePlan.addSegment(segment2);

        Desk desk = new Desk();
        Desk desk2 = new Desk();
        Desk desk3 = new Desk();
        Desk desk4 = new Desk();

        Chair chair = new Chair();
        Chair chair2 = new Chair();
        Chair chair3 = new Chair();
        Chair chair4 = new Chair();
        Chair chair5 = new Chair();
        Chair chair6 = new Chair();
        Chair chair7 = new Chair();
        Chair chair8 = new Chair();

        desk.addChair(chair);
        desk.addChair(chair2);
        desk2.addChair(chair3);
        desk2.addChair(chair4);
        desk3.addChair(chair5);
        desk3.addChair(chair6);
        desk4.addChair(chair7);
        desk4.addChair(chair8);

        chair.addDesk(desk);
        chair2.addDesk(desk);
        chair3.addDesk(desk2);
        chair4.addDesk(desk2);
        chair5.addDesk(desk3);
        chair6.addDesk(desk3);
        chair7.addDesk(desk4);
        chair8.addDesk(desk4);

        segment.addDesk(desk);
        segment.addDesk(desk2);
        segment2.addDesk(desk3);
        segment2.addDesk(desk4);

        desk.setSegment(segment);
        desk2.setSegment(segment);
        desk3.setSegment(segment2);
        desk4.setSegment(segment2);

        this.segmentRepo.save(segment);
        this.segmentRepo.save(segment2);
        this.tablePlanRepo.save(tablePlan);

        this.deskRepo.save(desk);
        this.deskRepo.save(desk2);
        this.deskRepo.save(desk3);
        this.deskRepo.save(desk4);

        this.chairRepo.save(chair);
        this.chairRepo.save(chair2);
        this.chairRepo.save(chair3);
        this.chairRepo.save(chair4);
        this.chairRepo.save(chair5);
        this.chairRepo.save(chair6);
        this.chairRepo.save(chair7);
        this.chairRepo.save(chair8);
    }

    @Test
    void testConnectionBetweenSegmentAndTablePlan() {
        List<TablePlan> tableList = this.tablePlanRepo.findAll();
        List<Segment> segmentList = this.segmentRepo.findAll();

        assertEquals(segmentList.get(0).getTablePlan().getTableplan_id(), tableList.get(0).getTableplan_id());
    }

    @Test
    void testConnectionBetweenDeskAndSegment() {
        List<Segment> segmentList = this.segmentRepo.findAll();
        List<Desk> deskList = this.deskRepo.findAll();

        assertEquals(deskList.get(0).getSegment().getSegment_id(), segmentList.get(0).getSegment_id());
    }

    @Test
    void testConnectionBetweenChairAndDesk() {
        List<Desk> deskList = this.deskRepo.findAll();
        List<Chair> chairList = this.chairRepo.findAll();

        assertEquals(chairList.get(0).getDesk().getDesk_id(), deskList.get(0).getDesk_id());
    }

}
