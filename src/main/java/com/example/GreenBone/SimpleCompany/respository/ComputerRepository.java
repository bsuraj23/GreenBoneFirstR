package com.example.GreenBone.SimpleCompany.respository;

import com.example.GreenBone.SimpleCompany.model.Computer;
import com.example.GreenBone.SimpleCompany.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ComputerRepository extends JpaRepository<Computer, Long> {

    List<Computer> findByEmployeeAbbreviation(String employeeAbbreviation);

    List<Computer> findByEmployee(Optional<Employee> employee);
}
