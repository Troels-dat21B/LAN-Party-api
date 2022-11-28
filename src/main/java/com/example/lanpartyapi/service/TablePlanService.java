package com.example.lanpartyapi.service;


import com.example.lanpartyapi.dto.TablePlanResponse;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TablePlanService {

    TablePlanRepo tablePlanRepo;
    SegmentRepo segmentRepo;

    public TablePlanService(TablePlanRepo tablePlanRepo, SegmentRepo segmentRepo) {
        this.tablePlanRepo = tablePlanRepo;
        this.segmentRepo = segmentRepo;
    }


    public TablePlanResponse findTablePlanById(@PathVariable int id) throws Exception {
        TablePlan found = tablePlanRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Table Plan not found"));
        return new TablePlanResponse(found);
    }

    public List<TablePlanResponse> findAllTablePlans() {
        List<TablePlan> plans = tablePlanRepo.findAll();
        return plans.stream().map(tablePlan -> new TablePlanResponse(tablePlan)).collect(Collectors.toList());
    }

    public void createTablePlan(String name) {
        this.tablePlanRepo.save(new TablePlan(name));
    }

    public void deleteTablePlan(int id) {
        Optional<TablePlan> tablePlan = this.tablePlanRepo.findById(id);
        if (tablePlan.isPresent()){
            this.tablePlanRepo.delete(tablePlan.get());
        }
    }

    public List<Segment> getTablePlanInfo(int id) {
        TablePlan found = tablePlanRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Table Plan not found"));
        return this.segmentRepo.findSegmentsBytableplan_id(found.getTableplan_id());

    }

    public List<TablePlan> getAllTablePlansInfo() {

        return null;
    }
}
