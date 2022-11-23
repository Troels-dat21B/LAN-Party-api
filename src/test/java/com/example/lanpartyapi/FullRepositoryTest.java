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
        tablePlan.addSegment(segment);
        segment.setTablePlan(tablePlan);
        segment2.setTablePlan(tablePlan);
        this.segmentRepo.save(segment);
        this.segmentRepo.save(segment2);

        this.tablePlanRepo.save(tablePlan);


        Desk desk = new Desk();
        Desk desk2 = new Desk();
        Desk desk3 = new Desk();
        Desk desk4 = new Desk();
        this.deskRepo.save(desk);
        this.deskRepo.save(desk2);
        this.deskRepo.save(desk3);
        this.deskRepo.save(desk4);

        Chair chair = new Chair();
        Chair chair2 = new Chair();
        Chair chair3 = new Chair();
        Chair chair4 = new Chair();
        Chair chair5 = new Chair();
        Chair chair6 = new Chair();
        Chair chair7 = new Chair();
        Chair chair8 = new Chair();
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
    void testConnectionBetweenEntities(){
        List<Segment> segmentList = this.segmentRepo.findAll();
        List<TablePlan> tableList = this.tablePlanRepo.findAll();
        System.out.println("sout1 : " + segmentList.get(0).getTablePlan());
        System.out.println("sout2 : " + tableList.get(0).getSegments());
        //assertEquals(segmentList.get(0).getTablePlan().getTableplan_id(), tableList.get(0).getTableplan_id());


    }


}
