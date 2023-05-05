package com.example.GreenBone.SimpleCompany.service;

import com.example.GreenBone.SimpleCompany.model.Employee;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public interface EmployeeService {

	public List<Employee> showEmployees();

	public void saveEmployee(Employee emp);

	public Employee findEmployeeById(Integer employeeId);

	public void deleteEmployee(Employee emp);

	public Employee findByFirstName(String firstName);

	public List<Employee> sortByFirstName(Direction direction);

    Employee getEmployeeByAbbreviation(String abbreviation);

    void updateEmployee(Long id, Employee employee);
}