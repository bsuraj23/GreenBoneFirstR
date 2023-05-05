package com.example.GreenBone.SimpleCompany.model;


import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Optional;

@Entity
@Getter
@Setter
public class Computer {
    @Id
    private String macAddress;
    private String name;
    private String ipAddress;
    private String employeeAbbreviation;
    private String description;
    @jakarta.persistence.Id
    private Long id;
    private String computerName;

    public void setEmployee(Optional<Employee> employee) {
    }


    // getters and setters
}
