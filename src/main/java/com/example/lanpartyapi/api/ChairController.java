package com.example.lanpartyapi.api;

import com.example.lanpartyapi.dto.*;
import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.Desk;
import com.example.lanpartyapi.entity.Segment;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.service.AdminService;
import com.example.lanpartyapi.service.ChairService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/createchair")
    public void createChairFromDesk(@RequestParam int id) {
        this.chairService.createChairFromDesk(id);
    }

    @PutMapping("/updatechair/{chair_id}")
    public ResponseEntity<Boolean> updateChai00r(@RequestBody ChairRequest body, @PathVariable("chair_id") int id) {
        this.chairService.updateChair(body, id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
