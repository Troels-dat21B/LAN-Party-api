package com.example.lanpartyapi.service;

import static org.junit.jupiter.api.Assertions.*;

import com.example.lanpartyapi.entity.*;
import com.example.lanpartyapi.repository.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ReservationServiceH2Test {


    private static ChairRepo chairRepo;
    private static DeskRepo deskRepo;
    private static SegmentRepo segmentRepo;
    private static TablePlanRepo tablePlanRepo;

    private static LanUserRepository lanUserRepo;

    private static ReservationRepository reservationRepo;

    private ReservationService reservationService;




    @BeforeAll
    static void setupBeforeTests(
            @Autowired ChairRepo chairRepository,
            @Autowired DeskRepo deskRepository,
            @Autowired SegmentRepo segmentRepository,
            @Autowired TablePlanRepo tablePlanRepository,
            @Autowired LanUserRepository lanUserRepository,
            @Autowired ReservationRepository reservationRepository
    ) {
        chairRepo = chairRepository;
        chairRepo.deleteAll();
        deskRepo = deskRepository;
        deskRepo.deleteAll();
        segmentRepo = segmentRepository;
        segmentRepo.deleteAll();
        tablePlanRepo = tablePlanRepository;
        tablePlanRepo.deleteAll();
        lanUserRepo = lanUserRepository;
        lanUserRepo.deleteAll();
        reservationRepo = reservationRepository;
        reservationRepo.deleteAll();

        LanUser user1 = new LanUser();
        user1.setUserType(LanUserType.USER);
        user1.setLanUserName("test_1");
        user1.setUserPassword("test");


        TablePlan tablePlan = new TablePlan();
        tablePlan.setName("Test tableplan");

        Segment segment = new Segment();
        Segment segment2 = new Segment();

        segment.setTableplan(tablePlan);
        segment2.setTableplan(tablePlan);

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
        lanUserRepo.save(user1);

        tablePlanRepo.save(tablePlan);
        segmentRepo.save(segment);
        segmentRepo.save(segment2);


        deskRepo.save(desk);
        deskRepo.save(desk2);
        deskRepo.save(desk3);
        deskRepo.save(desk4);

        chairRepo.save(chair);
        chairRepo.save(chair2);
        chairRepo.save(chair3);
        chairRepo.save(chair4);
        chairRepo.save(chair5);
        chairRepo.save(chair6);
        chairRepo.save(chair7);
        chairRepo.save(chair8);
    }

    @BeforeEach
    public void createService(){
        this.reservationService = new ReservationService(reservationRepo, lanUserRepo, chairRepo);

    }

    @Test
    public void saveMoreThanOneReservationTest(){
        List<Chair> chairs = chairRepo.findAll();
        List<Integer> chairIds = chairs.stream().map(chair -> chair.getChair_id()).toList();
        System.out.println("Fandt: " + chairIds);
        this.reservationService.create("test_1", chairIds);

        List<Chair> foundChairs = chairRepo.findAll();

        assertNotNull(foundChairs.get(0).getReservation());//<---- Assert :-)
        System.out.println(foundChairs.get(0).getReservation());

        assertEquals(1, foundChairs.get(0).getReservation().getId());
        for (Chair chair: foundChairs){
            System.out.println(chair.getReservation().getId());
        }
    }
}
