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
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ChairController {

    ChairService chairService;

    ChairController(ChairService chairService) {
        this.chairService = chairService;
    }
    @GetMapping("/chairs")
    public Iterable<ChairResponse> getTablePlan() {
        return this.chairService.findAllChairs();
    }

    @GetMapping("/chairsFromDesk")
    public List<ChairResponse> getChairsFromDesk(@RequestParam int id) {
        return this.chairService.getChairsFromDesk(id);
    }


    @DeleteMapping("/deletechair")
    public void deleteChair(@RequestParam int id) {
        this.chairService.deleteChair(id);
    }


}
