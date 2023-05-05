package com.example.GreenBone.SimpleCompany.serviceImpl;


import com.example.GreenBone.SimpleCompany.exception.ResourceNotFoundException;
import com.example.GreenBone.SimpleCompany.model.Computer;
import com.example.GreenBone.SimpleCompany.respository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class ComputerService {

    private ComputerRepository computerRepository;


    private RestTemplate restTemplate;

    private final String NOTIFICATION_URL = "http://admin-notification:8080/notify";

    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }

    public Computer createComputer(Computer computer) {
        if (computerRepository.findByMacAddress(computer.getMacAddress()).isPresent()) {
            throw new DuplicateKeyException("Computer with MAC address already exists");
        }
        return computerRepository.save(computer);
    }

    public Computer getComputerById(Long id) throws ResourceNotFoundException {
        return computerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Computer not found"));
    }



    public Computer getComputerByEmployeeId(Long id) throws ResourceNotFoundException {
        return computerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Do  not Have any ssytem asssigned "));
    }


    public Computer updateComputer(Long id, Computer computer) throws ResourceNotFoundException {
        Computer existingComputer = getComputerById(id);
        existingComputer.setMacAddress(computer.getMacAddress());
        existingComputer.setComputerName(computer.getComputerName());
        existingComputer.setIpAddress(computer.getIpAddress());
        existingComputer.setEmployeeAbbreviation(computer.getEmployeeAbbreviation());
        existingComputer.setDescription(computer.getDescription());
        return computerRepository.save(existingComputer);
    }

    public void deleteComputer(Long id) throws ResourceNotFoundException {
        Computer computer = getComputerById(id);
        computerRepository.delete(computer);
    }

    public void notifyAdminIfUserHasTooManyComputers(String employeeAbbreviation) {
        List<Computer> computers = computerRepository.findByEmployeeAbbreviation(employeeAbbreviation);
        if (computers.size() >= 3) {
            NotificationRequest request = new NotificationRequest(employeeAbbreviation, computers.size());
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
          HttpEntity<NotificationRequest> entity = new HttpEntity<>(request, headers);
           restTemplate.postForObject(NOTIFICATION_URL, entity, Void.class);
        }
    }
    public class NotificationRequest {
        private String employeeAbbreviation;
        private int computerCount;

        public NotificationRequest(String employeeAbbreviation, int size) {
        }

        // constructor, getters and setters
    }

}
