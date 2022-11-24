package com.example.lanpartyapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.lanpartyapi.api.AdminController;
import com.example.lanpartyapi.config.BeforeTestConfig;
import com.example.lanpartyapi.dto.TablePlanResponse;
import com.example.lanpartyapi.entity.TablePlan;
import com.example.lanpartyapi.repository.ChairRepo;
import com.example.lanpartyapi.repository.DeskRepo;
import com.example.lanpartyapi.repository.SegmentRepo;
import com.example.lanpartyapi.repository.TablePlanRepo;
import com.example.lanpartyapi.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class AdminControllerTest {

    @Autowired
    ChairRepo chairRepo;

    @Autowired
    DeskRepo deskRepo;

    @Autowired
    SegmentRepo segmentRepo;

    @Autowired
    TablePlanRepo tablePlanRepo;

    @Autowired
    AdminController adminController;

    @Autowired
    BeforeTestConfig beforeTestConfig;


    @BeforeEach
    void setupBeforeTests() {
        beforeTestConfig.setupBeforeTests();
    }


    @Test
    public void findAllControllerEndpoints() {
        //Får denne fejl "org.springframework.beans.factory.UnsatisfiedDependencyException:
        // Error creating bean with name 'com.example.lanpartyapi.AdminControllerTest':
        // Unsatisfied dependency expressed through field 'adminController';
        // nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException:
        // No qualifying bean of type 'com.example.lanpartyapi.api.AdminController' available:
        // expected at least 1 bean which qualifies as autowire candidate. Dependency annotations"

        TablePlanResponse response = new TablePlanResponse(tablePlanRepo.findByName("Test tableplan"));
        List<TablePlanResponse> plans = adminController.getTablePlans();
        assertEquals(response, plans.get(0));
    }

}
