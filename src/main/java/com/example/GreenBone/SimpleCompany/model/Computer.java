package com.example.GreenBone.SimpleCompany.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "computers")
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String serialNumber;

    // constructors, getters and setters
}

