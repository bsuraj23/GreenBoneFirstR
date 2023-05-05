package com.example.GreenBone.SimpleCompany.model;


import jakarta.persistence.*;


import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;

import java.util.Optional;

@Entity
@Getter
@Setter
@Table(name = "computers")
public class Computer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String macAddress;

    @NotNull
    private String computerName;

    @NotNull
    private String ipAddress;

    private String employeeAbbreviation;

    private String description;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getMacAddress() {
        return null;
    }

    // constructors, getters and setters
}
