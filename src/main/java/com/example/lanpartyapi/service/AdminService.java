package com.example.lanpartyapi.service;

import com.example.lanpartyapi.dto.ChairResponse;
<<<<<<< HEAD
=======
import com.example.lanpartyapi.dto.DeskResponse;
import com.example.lanpartyapi.dto.SegmentResponse;
>>>>>>> 1326ffd55d88b296ffcd284701bf80e9a9f34c6e
import com.example.lanpartyapi.dto.TablePlanResponse;
import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.DeskRepo;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {
    ChairRepo chairRepo;
    DeskRepo deskRepo;
    SegmentRepo segmentRepo;
    TablePlanRepo tablePlanRepo;


    AdminService(ChairRepo chairRepo, DeskRepo deskRepo, SegmentRepo segmentRepo, TablePlanRepo tablePlanRepo) {
        this.chairRepo = chairRepo;
        this.deskRepo = deskRepo;
        this.segmentRepo = segmentRepo;
        this.tablePlanRepo = tablePlanRepo;
    }

    public List<Segment> getSegments() {
        return this.segmentRepo.findAll();
    }

    public TablePlanResponse findTablePlanById(@PathVariable int id) throws Exception {
        TablePlan found = tablePlanRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        return new TablePlanResponse(found);
    }

    public List<TablePlanResponse> findAllTablePlans(){
        List<TablePlan> plans = tablePlanRepo.findAll();
        return plans.stream().map(tablePlan -> new TablePlanResponse(tablePlan)).collect(Collectors.toList());
    }

    public List<SegmentResponse> findAllSegments(){
        List<Segment> segments = segmentRepo.findAll();
        return segments.stream().map(segment -> new SegmentResponse(segment)).collect(Collectors.toList());
    }

    public List<DeskResponse> findAllDesks(){
        List<Desk> desks = deskRepo.findAll();
        return desks.stream().map(desk -> new DeskResponse(desk)).collect(Collectors.toList());
    }

    public List<ChairResponse> findAllChairs(){
<<<<<<< HEAD
        List<Chair> plans = this.chairRepo.findAll();
        return plans.stream().map(chair -> new ChairResponse(chair)).collect(Collectors.toList());
=======
        List<Chair> chairs = chairRepo.findAll();
        return chairs.stream().map(chair -> new ChairResponse(chair)).collect(Collectors.toList());
>>>>>>> 1326ffd55d88b296ffcd284701bf80e9a9f34c6e
    }

}