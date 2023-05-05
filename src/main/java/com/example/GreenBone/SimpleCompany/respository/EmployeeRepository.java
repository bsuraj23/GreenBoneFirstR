package com.example.GreenBone.SimpleCompany.respository;

import com.example.GreenBone.SimpleCompany.model.Employee;
import com.example.GreenBone.SimpleCompany.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByAbbreviation(String abbreviation);
}
