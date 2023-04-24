package com.example.GreenBone.SimpleCompany.respository;

import com.example.GreenBone.SimpleCompany.model.Assets;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
