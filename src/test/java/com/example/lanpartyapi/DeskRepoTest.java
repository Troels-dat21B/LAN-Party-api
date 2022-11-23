package com.example.lanpartyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.repository.DeskRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class DeskRepoTest {
    @Autowired
    DeskRepo tR;

    @BeforeEach
    void beforeEachTest(){
        Desk desk = new Desk();
        Desk desk2 = new Desk();
        this.tR.save(desk);
        this.tR.save(desk2);
    }

    @Test
    void findDesks(){
        List<Desk> desks = this.tR.findAll();
        assertEquals(1, desks.get(0).getDesk_id());
        assertEquals(2, desks.get(1).getDesk_id());
        assertEquals(2, desks.size());
    }

}
