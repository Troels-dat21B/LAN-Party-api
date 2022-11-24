package com.example.lanpartyapi.api;

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


    @GetMapping("/tableplan")
    public Iterable<TablePlan> getTablePlan(){

        return this.adminService.getTablePlans();

    }






}
