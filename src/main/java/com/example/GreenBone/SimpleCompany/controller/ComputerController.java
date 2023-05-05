package com.example.GreenBone.SimpleCompany.controller;
import com.example.GreenBone.SimpleCompany.exception.ResourceNotFoundException;
import com.example.GreenBone.SimpleCompany.model.Computer;
import com.example.GreenBone.SimpleCompany.respository.ComputerRepository;
import com.example.GreenBone.SimpleCompany.serviceImpl.ComputerService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/computers")
public class ComputerController {

    private ComputerService computerService;

// m administrator wants to be able to get all computers
    @GetMapping
    public List<Computer> getAllComputers() {
        return computerService.getAllComputers();
    }

    @PostMapping
    public Computer createComputer(@RequestBody Computer computer) {
        //add code to check if employee has more than 2 and this addition sahll trigger alarm
        return computerService.createComputer(computer);

    }

    //administrator wants to be able to get the data of a single computer
    @GetMapping("/{id}")
    public Computer getComputerById(@PathVariable Long id) throws ResourceNotFoundException {
        return computerService.getComputerById(id);
    }

    //m administrator wants to be able to get all assigned computers for an employee
    @GetMapping("/{id}")
    public Computer getComputerByEmployeeId(@PathVariable Long id) throws ResourceNotFoundException {
        return computerService.getComputerById(id);
    }



   // administrator wants to be able to add a new computer to an employee
   //administrator wants to be able to assign a computer to another employee
    @PutMapping("/{id}")
    public Computer updateComputer(@PathVariable Long id, @RequestBody Computer computer) throws ResourceNotFoundException {
        return computerService.updateComputer(id, computer);
    }

    //admidnistrator wants to be able to remove a computer from an employee
    @DeleteMapping("/{id}")
    public void deleteComputer(@PathVariable Long id) throws ResourceNotFoundException {
        computerService.deleteComputer(id);
    }
//administrator wants to be informed when an employee is assigned 3 or more computers
    @PostMapping("/notify")
    public void notifyAdmin(@RequestParam String employeeAbbreviation) {
        computerService.notifyAdminIfUserHasTooManyComputers(employeeAbbreviation);
    }
}
