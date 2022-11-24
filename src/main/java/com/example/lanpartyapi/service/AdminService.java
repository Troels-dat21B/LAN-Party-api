package com.example.lanpartyapi.service;

import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.DeskRepo;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    ChairRepo chairRepo;
    DeskRepo deskRepo;
    SegmentRepo segmentRepo;
    TablePlanRepo tablePlanRepo;



    AdminService(ChairRepo chairRepo, DeskRepo deskRepo, SegmentRepo segmentRepo, TablePlanRepo tablePlanRepo){
        this.chairRepo = chairRepo;
        this.deskRepo = deskRepo;
        this.segmentRepo = segmentRepo;
        this.tablePlanRepo = tablePlanRepo;
    }


    public List<TablePlan> getTablePlans(){
        return this.tablePlanRepo.findAll();
    }

}
