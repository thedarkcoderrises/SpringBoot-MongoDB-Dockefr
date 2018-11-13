package com.nevado.persistence;

import com.nevado.model.EmpSal;
import com.nevado.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMongoQueryRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

   public List<Employee> findAllLessThanGivenSal(Double sal){

       List<Employee> employees = mongoTemplate.find(
               (Query.query(Criteria.where("sal").lt(sal))),Employee.class);
       return employees;
    }

    public Double calcSal(Double sal){

        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("sal").lt(sal)),
                Aggregation.group("managerEmail").sum("sal").as("totalSal"),
                Aggregation.project("totalSal").and("managerEmail")
        );

         return mongoTemplate.aggregate(agg,"employees", EmpSal.class).getMappedResults().get(0).getTotalSal();
    }
}
