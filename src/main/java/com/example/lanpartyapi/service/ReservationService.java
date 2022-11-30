package com.example.lanpartyapi.service;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.LanUser;
import com.example.lanpartyapi.entity.Reservation;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.LanUserRepository;
import com.example.lanpartyapi.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final LanUserRepository lanUserRepository;
    private final ChairRepo chairRepo;

    public ReservationService(
            ReservationRepository reservationRepository,
            LanUserRepository lanUserRepository,
            ChairRepo chairRepo
    ) {
        this.reservationRepository = reservationRepository;
        this.lanUserRepository = lanUserRepository;
        this.chairRepo = chairRepo;
    }

    public List<Reservation> findByLanUserName(String username) {
        return this.reservationRepository.findByLanUser_LanUserName(username);
    }

    public void create(String lanUserName, int chairId) {
        var lanUserOptional = this.lanUserRepository.findById(lanUserName);
        var chairOptional = this.chairRepo.findById(chairId);

        var lanUser = lanUserOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        var chair = chairOptional.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        if (chair.is_reserved()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        chair.set_reserved(true);

        var reservation = new Reservation();
        reservation.setLanUser(lanUser);
        reservation.setChair(chair);

        this.reservationRepository.save(reservation);
    }
}
