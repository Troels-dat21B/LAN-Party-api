package com.example.lanpartyapi.api;

import com.example.lanpartyapi.dto.ReservationRequest;
import com.example.lanpartyapi.entity.Reservation;
import com.example.lanpartyapi.service.AuthService;

import com.example.lanpartyapi.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/reservation")
public class ReservationController {

    private final AuthService authService;
    private final ReservationService reservationService;

    public ReservationController(
            AuthService authService,
            ReservationService reservationService
    ) {
        this.authService = authService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getUserReservation(@RequestBody HashMap<String, String> body) {
        var accessToken = body.get("accessToken");
        var payload = this.authService.authorize("Bearer " + accessToken);

        return this.reservationService.findByLanUserName(payload.getUsername());
    }

    @PostMapping
    public ResponseEntity<String> create(
            @RequestHeader("Authorization") String auth,
            @RequestBody ReservationRequest reservationRequest
    ) {
        var payload = this.authService.authorize(auth);

        this.reservationService.create(payload.getUsername(), reservationRequest.getChairId());

        return new ResponseEntity<>("Successfully created new reservation", HttpStatus.OK);
    }
}