package com.example.GreenBone.SimpleCompany.model;


import org.hibernate.annotations.Table;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;

    // constructors, getters and setters
}
