package com.example.lanpartyapi.service;


import com.example.lanpartyapi.dto.ChairResponse;
import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.DeskRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChairService {

    ChairRepo chairRepo;

    DeskRepo deskRepo;

    public ChairService(ChairRepo chairRepo, DeskRepo deskRepo) {
        this.chairRepo = chairRepo;
        this.deskRepo = deskRepo;
    }

    public List<ChairResponse> findAllChairs() {
        List<Chair> plans = this.chairRepo.findAll();
        return plans.stream().map(chair -> new ChairResponse(chair)).collect(Collectors.toList());
    }

    public List<ChairResponse> getChairsFromDesk(int id) {
        Desk desk = this.deskRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Segment not found"));
        List<Chair> chairs = desk.getChairs();
        List<ChairResponse> found = new ArrayList<>();

        return chairs.stream().map(chair -> new ChairResponse(chair)).collect(Collectors.toList());
        //for (int i = 0; i < chairs.size(); i++) {
        //    found.add(new ChairResponse(chairs.get(i)));
    }

    public void deleteChair(int id) {
        Optional<Chair> chair = this.chairRepo.findById(id);
        if (chair.isPresent()){
            this.chairRepo.delete(chair.get());
        }
    }
}
