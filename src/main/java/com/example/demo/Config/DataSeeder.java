package com.example.demo.Config;
 import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.Entity.Employee;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class DataSeeder {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    public void seedData() {
        if (employeeRepository.count() > 0) return; // avoid duplicate inserts on restart

        employeeRepository.saveAll(List.of(
        	
            new Employee(null, "Aarav Sharma",  "aarav.sharma@company.com", new Date(121, 2,  15), 28, 65000 ),
            new Employee(null, "Priya Patel",   "priya.patel@company.com",  new Date(119, 6,  1),  34, 95000),
            new Employee(null, "Rohit Mehta",   "rohit.mehta@company.com" , new Date(115, 0,  10),  45, 120000),
            new Employee(null, "Sneha Iyer",    "sneha.iyer@company.com",  new Date(122, 5,  20),  29, 72000),
            new Employee(null, "Karan Verma",   "karan.verma@company.com",   new Date(118, 10, 5), 37, 88000),
            new Employee(null, "Ananya Reddy",  "ananya.reddy@company.com", new Date(123, 0,  17), 26, 58000 ),
            new Employee(null, "Vikram Singh",  "vikram.singh@company.com", new Date(116, 7,  23),  41, 105000),
            new Employee(null, "Divya Nair",    "divya.nair@company.com",  new Date(120, 3,  11),  31, 79000),
            new Employee(null, "Manish Gupta",  "manish.gupta@company.com",  new Date(110, 8,  30),  52, 145000)

        ));

        System.out.println("✅ Employee data seeded successfully!");
    }
}