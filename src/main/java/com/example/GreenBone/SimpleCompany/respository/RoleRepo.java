package com.example.GreenBone.SimpleCompany.respository;

import employeeManagement.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}