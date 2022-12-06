/*
package com.example.lanpartyapi.service;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.LanUser;
import com.example.lanpartyapi.entity.LanUserType;
import com.example.lanpartyapi.entity.Reservation;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.LanUserRepository;
import com.example.lanpartyapi.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @Mock
    private LanUserRepository lanUserRepository;
    @Mock
    private ChairRepo chairRepo;
    @Autowired
    private ReservationService reservationService;

    @BeforeEach
    void setUpService() {
        this.reservationService = new ReservationService(
                this.reservationRepository,
                this.lanUserRepository,
                this.chairRepo
        );
    }

    @Test
    void create() {
        Mockito.when(this.lanUserRepository.findById(Mockito.anyString()))
                .thenReturn(Optional.of(new LanUser()));

        Mockito.when(this.chairRepo.findById(Mockito.anyInt()))
                        .thenReturn(Optional.of(new Chair()));

        this.reservationService.create("test", 1);

        Mockito.verify(this.reservationRepository,
                Mockito.times(1)).save(Mockito.any(Reservation.class));
    }
}*/
