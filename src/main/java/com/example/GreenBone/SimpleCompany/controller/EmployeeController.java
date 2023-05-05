//package com.example.GreenBone.SimpleCompany.controller;
//
//import com.example.GreenBone.SimpleCompany.model.Employee;
//import com.example.GreenBone.SimpleCompany.service.EmployeeService;
//import com.example.GreenBone.SimpleCompany.service.EmployeeService2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//	@Autowired
//	private EmployeeService employeeService;
//
//	@GetMapping
//	public Object getEmployeeByName(@RequestParam(required = false) String firstName) {
//		if (firstName == null)
//			return employeeService.showEmployees();
//		return employeeService.findByFirstName(firstName);
//	}
//
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Employee addEmployee(@RequestBody Employee emp) {
//		emp.setEmployeeId(0);
//		employeeService.saveEmployee(emp);
//		return emp;
//	}
//
//	@GetMapping("/{employeeId}")
//	public Employee getEmployeeById(@PathVariable Integer employeeId) {
//		Employee emp = employeeService.findEmployeeById(employeeId);
//		return emp;
//	}
//
//	@PutMapping
//	public Employee updateEmployee(@RequestBody Employee emp) {
//		employeeService.saveEmployee(emp);
//		return emp;
//	}
//
//	@DeleteMapping("/{employeeId}")
//	public String deleteEmployee(@PathVariable Integer employeeId) {
//		Employee emp = employeeService.findEmployeeById(employeeId);
//		employeeService.deleteEmployee(emp);
//		return "Deleted employee ID - " + employeeId;
//	}
//
//	@GetMapping("/sort")
//	public List<Employee> getEmployeesSortedByFirstName(Direction direction) {
//		List<Employee> emp = employeeService.sortByFirstName(direction);
//		return emp;
//	}
//}