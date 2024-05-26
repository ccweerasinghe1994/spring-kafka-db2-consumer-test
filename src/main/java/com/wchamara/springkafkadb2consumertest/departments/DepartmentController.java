package com.wchamara.springkafkadb2consumertest.departments;

import com.wchamara.springkafkadb2consumertest.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departments")
public class DepartmentController {


    Db2Repository db2Repository;

    Producer producer;

    public DepartmentController(Db2Repository db2Repository, Producer producer) {
        this.db2Repository = db2Repository;
        this.producer = producer;
    }

    @PostMapping
    public ResponseEntity<Department> getDepartments() {

        Department department = new Department();

        department.setName("IT");
        department.setLocation("Colombo");

        Department saved = db2Repository.save(department);

        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<Department> saveAndTriggerTopic(){

            Department department = new Department();
            department.setName("IT");
            department.setLocation("Colombo");
            db2Repository.save(department);
            producer.sendMessage(department.getName());

            return ResponseEntity.ok(department);
    }


}
