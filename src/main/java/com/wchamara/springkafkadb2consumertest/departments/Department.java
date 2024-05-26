package com.wchamara.springkafkadb2consumertest.departments;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    @Id
    @GeneratedValue(
            strategy = jakarta.persistence.GenerationType.IDENTITY
    )
    private long id;
    private String name;
    private String location;
}
