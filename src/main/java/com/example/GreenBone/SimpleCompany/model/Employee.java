package com.example.GreenBone.SimpleCompany.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "employees")
public class Employee {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String abbreviation;

    private String firstName;
    private String lastName;
    private String email;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Computer> getComputers() {
        return null;
    }

    public Object getAbbreviation() {
        return null;
    }

    // constructors, getters and setters
}
