package com.example.GreenBone.SimpleCompany.serviceImpl;


import com.example.GreenBone.SimpleCompany.model.Computer;
import com.example.GreenBone.SimpleCompany.model.Employee;
import com.example.GreenBone.SimpleCompany.respository.ComputerRepository;
import com.example.GreenBone.SimpleCompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerService {

    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer getComputerByMacAddress(String macAddress) {
        return computerRepository.findById(Long.valueOf(macAddress)).orElse(null);
    }

    public Computer addComputer(Computer computer) {
        return computerRepository.save(computer);
    }

    public Computer updateComputer(String macAddress, Computer computer) {
        Computer existingComputer = computerRepository.findById(Long.valueOf(macAddress)).orElse(null);
        if (existingComputer != null) {
            existingComputer.setId(Long.valueOf(computer.getName()));
            existingComputer.setIpAddress(computer.getIpAddress());
            existingComputer.setEmployeeAbbreviation(computer.getEmployeeAbbreviation());
            existingComputer.setDescription(computer.getDescription());
            return computerRepository.save(existingComputer);
        }
        return null;
    }

    public void deleteComputer(String macAddress) {
        computerRepository.deleteById(Long.valueOf(macAddress));
    }
}
