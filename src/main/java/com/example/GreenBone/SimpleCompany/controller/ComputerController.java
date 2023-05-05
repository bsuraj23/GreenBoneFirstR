package com.example.GreenBone.SimpleCompany.controller;
import com.example.GreenBone.SimpleCompany.exception.ResourceNotFoundException;
import com.example.GreenBone.SimpleCompany.model.Computer;
import com.example.GreenBone.SimpleCompany.model.Employee;
import com.example.GreenBone.SimpleCompany.respository.ComputerRepository;
import com.example.GreenBone.SimpleCompany.respository.EmployeeRepository;
import com.example.GreenBone.SimpleCompany.serviceImpl.ComputerService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/computers")
public class ComputerController {

    @Autowired
    private ComputerRepository computerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${messagingServiceUrl}")
    private String messagingServiceUrl;

    @PostMapping("/")
    public Computer addComputerToEmployee(@RequestBody Computer computer, @RequestParam(required = false) String employeeAbbreviation) {
        Optional<Employee> employee = null;
        if (employeeAbbreviation != null) {
            employee = employeeRepository.findByAbbreviation(employeeAbbreviation);
            if (employee == null) {
               // throw new EmployeeNotFoundException();
            }
        }
        computer.setEmployee(employee);
        computerRepository.save(computer);

        // Check if the employee has 3 or more computers assigned
        if (employee != null && employee.getComputers().size() >= 3) {
            // Send a message to the messaging service
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            Message message = new Message( + " has 3 or more computers assigned");
            HttpEntity<Message> requestEntity = new HttpEntity<>(message, headers);
            restTemplate.postForObject(messagingServiceUrl, requestEntity, String.class);
        }

        return computer;
    }

    @GetMapping("/")
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Computer getComputerById(@PathVariable Long id) {
       // return computerRepository.findById(id).orElseThrow(ComputerNotFoundException::new);
    }

    @GetMapping("/employee/{abbreviation}")
    public List<Computer> getComputersByEmployeeAbbreviation(@PathVariable String abbreviation) {
        Optional<Employee> employee = employeeRepository.findByAbbreviation(abbreviation);
        if (employee == null) {
          //  throw new EmployeeNotFoundException();
        }
        return computerRepository.findByEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void removeComputerFromEmployee(@PathVariable Long id) {
        Optional<Computer> computer = computerRepository.findById(id);
                //.orElseThrow(ComputerNotFoundException::new);
        computer.setEmployee(null);
        computerRepository.save(computer);
    }

    @PutMapping("/{id}")
    public Computer updateComputer(@PathVariable Long id, @RequestBody Computer newComputer) {
        Computer computer = computerRepository.findById(id)
                //.orElseThrow(ComputerNotFoundException::new);
        computer.setName(newComputer.getName());
        computer.setMacAddress(newComputer.getMacAddress());
        computer.setIpAddress(newComputer.getIpAddress());
        computer.setDescription(newComputer.getDescription());
        computerRepository.save(computer);
        return computer;
    }
}

//
//@RestController
//@RequestMapping("/computers")
//public class ComputerController {
//    @Autowired
//    private ComputerService computerService;
//
//    @GetMapping("")
//    public List<Computer> getAllComputers() {
//        return computerService.getAllComputers();
//    }
//
//    @GetMapping("/{macAddress}")
//    public Computer getComputerByMacAddress(@PathVariable String macAddress) {
//        return computerService.getComputerByMacAddress(macAddress);
//    }
//
//    @PostMapping("")
//    public Computer addComputer(@RequestBody Computer computer) {
//        return computerService.addComputer(computer);
//    }
//
//    @PutMapping("/{macAddress}")
//    public Computer updateComputer(@PathVariable String macAddress, @RequestBody Computer computer) {
//        return computerService.updateComputer(macAddress, computer);
//    }
//
//    @DeleteMapping("/{macAddress}")
//    public void deleteComputer(@PathVariable String macAddress) {
//        computerService.deleteComputer(macAddress);
//    }
//}
