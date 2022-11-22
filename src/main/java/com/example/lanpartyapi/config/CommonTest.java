package com.example.lanpartyapi.config;

import com.example.lanpartyapi.entity.Chair;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import com.example.lanpartyapi.repository.TableRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
public class CommonTest implements ApplicationRunner {

    ChairRepo chairRepo;
    SegmentRepo segmentRepo;
    TableRepo tableRepo;
    TablePlanRepo tablePlanRepo;


    public CommonTest(ChairRepo chairRepo, SegmentRepo segmentRepo, TableRepo tableRepo, TablePlanRepo tablePlanRepo) {

        this.chairRepo = chairRepo;
        this.segmentRepo = segmentRepo;
        this.tableRepo = tableRepo;
        this.tablePlanRepo = tablePlanRepo;

    }




    @Override
    public void run(ApplicationArguments args) throws Exception {

        TablePlan myTablePlan1 = new TablePlan();

        tablePlanRepo.save(myTablePlan1);

        System.out.println(tableRepo.findById(0));


    }
}
