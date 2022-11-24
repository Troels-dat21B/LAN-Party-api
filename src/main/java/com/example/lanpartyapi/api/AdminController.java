package com.example.lanpartyapi.api;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class AdminController {

    AdminService adminService;

    AdminController(AdminService adminService){
        this.adminService = adminService;
    }


    @GetMapping("/tableplans")
    public Iterable<TablePlan> getTablePlans(){

        return this.adminService.getTablePlans();

    }

    @GetMapping("/segments")
    public List<Segment> getSegments(){
        return this.adminService.getSegments();

    }
    @GetMapping("/desks")
    public Iterable<Desk> getDesks(){

        return this.adminService.getDesks();

    }
    @GetMapping("/chairs")
    public Iterable<Chair> getTablePlan(){

        return this.adminService.getChairs();

    }






}
