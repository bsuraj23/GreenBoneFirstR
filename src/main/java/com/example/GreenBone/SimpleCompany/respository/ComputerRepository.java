package com.example.GreenBone.SimpleCompany.respository;

import com.example.GreenBone.SimpleCompany.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ComputerRepository extends JpaRepository<Computer, Long> {

}
