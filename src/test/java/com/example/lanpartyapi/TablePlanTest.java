package com.example.lanpartyapi;
import com.example.lanpartyapi.entity.TablePlan;
import org.junit.jupiter.api.Test;

@Test
public class TablePlanTest {

    TablePlan myTablePlan1 = new TablePlan();
        myTablePlan1.setName("Bordplan1");
        myTablePlan1.setTableplan_id(1);
        tablePlanRepo.save(myTablePlan1);
    String name = tablePlanRepo.findById(1).get().getName();
        System.out.println(name);
        System.out.println(tablePlanRepo.findAll().

    toArray().

    toString());

}
