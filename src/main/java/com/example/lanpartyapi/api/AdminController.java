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
        List<Segment> myList = this.adminService.getSegments();
        System.out.println("Here is the segment data:" + myList);
        System.out.println("More data:" + myList.get(0).getSegment_id() + " " + myList.get(0).getTableplan() + " " + myList.get(0).getDesks());
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
