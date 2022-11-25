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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class DeskController {

    AdminService adminService;

    DeskController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/desks")
    public Iterable<DeskResponse> getDesks() {
        return this.adminService.findAllDesks();
    }


    @GetMapping("/desk")
    public DeskResponse getOneDesk(@RequestParam int id){
        return this.adminService.getOneDesk(id);
    }

    //TODO desk from segment
    @GetMapping("/deskfromsegment")
    public List<DeskResponse> getDesksFromSegment(@RequestParam int id){//<-- Segment id

        return this.adminService.getDeskFromSegment(id);
    }


/*
    @GetMapping("/updatedesk")

    @GetMapping("/deletedesk")

    @GetMapping("/createdesk")*/
}
