package com.eviro.assessment.grad001.kennymafuna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.eviro.assessment.grad001.kennymafuna.entity")
@ComponentScan(basePackages = "com.eviro.assessment.grad001.kennymafuna")
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class);

        // Call the method to create and populate tables
        DataBaseManagementSystem dataBaseManagementSystem = new DataBaseManagementSystem();
        dataBaseManagementSystem.createAndPopulateTables();
    }
}
