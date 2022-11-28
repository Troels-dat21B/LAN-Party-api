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
import com.example.lanpartyapi.service.ChairService;
import com.example.lanpartyapi.service.DeskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DeskController {

    DeskService deskService;

    DeskController(DeskService deskService) {
        this.deskService = deskService;
    }

    @GetMapping("/desks")
    public Iterable<DeskResponse> getDesks() {
        return this.deskService.findAllDesks();
    }

    @GetMapping("/desk")
    public DeskResponse getOneDesk(@RequestParam int id){
        return this.deskService.getOneDesk(id);
    }

    //TODO desk from segment
    @GetMapping("/deskfromsegment")
    public List<DeskResponse> getDesksFromSegment(@RequestParam int id){//<-- Segment id

        return this.deskService.getDeskFromSegment(id);
    }




    /*
    @GetMapping("/createdesk")

    @GetMapping("/updatedesk")
*/
    @DeleteMapping("/deletedesk")
    public void deleteDesk(@RequestParam int id){
        this.deskService.deleteDesk(id);
    }

}
