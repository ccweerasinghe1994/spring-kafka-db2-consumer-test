package com.wchamara.springkafkadb2consumertest.producer;

import com.wchamara.springkafkadb2consumertest.departments.Db2Repository;
import com.wchamara.springkafkadb2consumertest.departments.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    Logger log = LoggerFactory.getLogger(Consumer.class);
    Db2Repository db2Repository;


    public Consumer(Db2Repository db2Repository) {
        this.db2Repository = db2Repository;
    }

    @KafkaListener(topics = "poems")
    public void consumeEvents(String message) {
        log.info("consumer consume the events {} ", message);
        try {
            Department department = new Department();
            department.setName(message);
            department.setLocation("Colombo");
            db2Repository.save(department);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
