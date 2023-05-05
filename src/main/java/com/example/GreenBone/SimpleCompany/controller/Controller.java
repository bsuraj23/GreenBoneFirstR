///*
// *
// *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
// *   Staxrt - sample application source code.
// *   http://staxrt.com
// *
// *   Licensed under the Apache License, Version 2.0 (the "License");
// *   you may not use this file except in compliance with the License.
// *   You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// *   Unless required by applicable law or agreed to in writing, software
// *   distributed under the License is distributed on an "AS IS" BASIS,
// *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// *   See the License for the specific language governing permissions and
// *   limitations under the License.
// *
// */
//
//package com.example.GreenBone.SimpleCompany.controller;
//
//import com.example.GreenBone.SimpleCompany.respository.Repository;
//import com.example.GreenBone.SimpleCompany.service.EmployeeService2;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1")
//public class Controller {
//
//  @Autowired
//  private Repository userRepository;
//  @Autowired
//  private EmployeeService2 employeeService;
//
//
//
//  @GetMapping
//  public Object getEmployeeByName(@RequestParam(required = false) String firstName) {
//    if (firstName == null)
//      return employeeService.showEmployees();
//    return employeeService.findByFirstName(firstName);
//  }
//
//  @PostMapping
//  @ResponseStatus(HttpStatus.CREATED)
//  public Employee addEmployee(@RequestBody Employee emp) {
//    emp.setEmployeeId(0);
//    employeeService.saveEmployee(emp);
//    return emp;
//  }
//
//  @GetMapping("/{employeeId}")
//  public Employee getEmployeeById(@PathVariable Integer employeeId) {
//    Employee emp = employeeService.findEmployeeById(employeeId);
//    return emp;
//  }
//
//  @PutMapping
//  public Employee updateEmployee(@RequestBody Employee emp) {
//    employeeService.saveEmployee(emp);
//    return emp;
//  }
//
//  @DeleteMapping("/{employeeId}")
//  public String deleteEmployee(@PathVariable Integer employeeId) {
//    Employee emp = employeeService.findEmployeeById(employeeId);
//    employeeService.deleteEmployee(emp);
//    return "Deleted employee ID - " + employeeId;
//  }
//
//  @GetMapping("/sort")
//  public List<Employee> getEmployeesSortedByFirstName(Direction direction) {
//    List<Employee> emp = employeeService.sortByFirstName(direction);
//    return emp;
//  }
//}
