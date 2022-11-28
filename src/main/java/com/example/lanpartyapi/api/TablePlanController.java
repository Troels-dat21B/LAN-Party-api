package com.example.lanpartyapi.api;

import com.example.lanpartyapi.dto.ChairResponse;
import com.example.lanpartyapi.dto.DeskResponse;
import com.example.lanpartyapi.dto.SegmentResponse;
import com.example.lanpartyapi.dto.TablePlanResponse;
import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.service.AdminService;
import com.example.lanpartyapi.service.TablePlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class TablePlanController {

    TablePlanService tablePlanService;

    TablePlanController(TablePlanService tablePlanService) {
        this.tablePlanService = tablePlanService;
    }

    @GetMapping("/tableplans")
    public List<TablePlanResponse> getTablePlans() {

        return this.tablePlanService.findAllTablePlans();

    }


    @PostMapping("/createtableplan")
    public void createTablePlan(@RequestParam String name) {
        this.tablePlanService.createTablePlan(name);
    }


    @DeleteMapping("/deletetableplan")
    public void deleteTablePlan(@RequestParam int id) {
        this.tablePlanService.deleteTablePlan(id);
    }


}
