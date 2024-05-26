package com.wchamara.springkafkadb2consumertest.departments;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Db2Repository extends JpaRepository<Department, Long> {
}
