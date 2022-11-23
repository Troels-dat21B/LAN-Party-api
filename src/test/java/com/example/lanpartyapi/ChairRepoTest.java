package com.example.lanpartyapi;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.repository.ChairRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class ChairRepoTest {
    @Autowired
    ChairRepo cR;

    @BeforeEach
    void chairSetup(){
        Chair chair = new Chair();
        Chair chair2 = new Chair();
        chair2.set_reserved(true);
        this.cR.save(chair);
        this.cR.save(chair2);
    }


    @Test
    void testForChairs(){
        List<Chair> chairs = this.cR.findAll();
        assertEquals(1, chairs.get(0).getChair_id());
        assertEquals(2, chairs.get(1).getChair_id());
        assertEquals(2, chairs.size());
        assertTrue(chairs.get(1).is_reserved());
    }


}
