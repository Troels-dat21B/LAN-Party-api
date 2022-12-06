/*
package com.example.lanpartyapi.repository;

import com.example.lanpartyapi.entity.LanUser;
import com.example.lanpartyapi.entity.LanUserType;
import com.example.lanpartyapi.entity.Reservation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReservationRepositoryTest {

    private static LanUserRepository lanUserRepository;
    private static ReservationRepository reservationRepository;

    private static String user1Username;
    private static String user2Username;

    private static int reservation1Id;

    @BeforeAll
    public static void setup(@Autowired LanUserRepository userRepository, @Autowired ReservationRepository reservationRepo) {
        lanUserRepository = userRepository;
        reservationRepository = reservationRepo;
        lanUserRepository.deleteAll();

        Reservation reservation1 = new Reservation();
        Reservation reservation2 = new Reservation();
        Reservation reservation3 = new Reservation();
        Reservation reservation4 = new Reservation();

        LanUser user1 = new LanUser(
                "test 1",
                "test",
                LanUserType.USER,
                List.of()
        );
        LanUser user2 = new LanUser(
                "test 2",
                "test",
                LanUserType.USER,
                List.of()
        );

        //Save users before reservations to avoid foreignkey error
        lanUserRepository.save(user1);
        lanUserRepository.save(user2);

        reservation1.setLanUser(user1);
        reservation2.setLanUser(user1);
        reservation3.setLanUser(user2);
        reservation4.setLanUser(user2);

        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);

        user1Username = user1.getLanUserName();
        user2Username = user2.getLanUserName();

        reservation1Id = reservation1.getId();
    }

    @Test
    void findByLanUser_LanUserName() {
        var user1 = lanUserRepository.findById(user1Username).orElseThrow();
        var user2 = lanUserRepository.findById(user2Username).orElseThrow();

        //Assert that all reservations that the users has are associated with that user
        user1.getReservations().forEach(
                reservation -> assertEquals(user1Username, reservation.getOwnerUsername())
        );
        user2.getReservations().forEach(
                reservation -> assertEquals(user2Username, reservation.getOwnerUsername())
        );
    }
}
*/
