package com.example.lanpartyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.repository.DeskRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class DeskRepoTest {

    public static DeskRepo tR;

    @BeforeAll
    static void beforeEachTest(@Autowired DeskRepo deskRepo){
        tR = deskRepo;
        tR.deleteAll();

        Desk desk = new Desk();
        Desk desk2 = new Desk();
        tR.save(desk);
        tR.save(desk2);
    }

    @Test
    void findDesks(){
        List<Desk> desks = tR.findAll();

        desks.forEach(desk -> System.out.println(desk.getDesk_id()));

        assertEquals(1, desks.get(0).getDesk_id());
        assertEquals(2, desks.get(1).getDesk_id());
        assertEquals(2, desks.size());
    }

}
