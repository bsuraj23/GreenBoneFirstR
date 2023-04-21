package com.example.GreenBone.SimpleCompany.respository;

import com.example.GreenBone.SimpleCompany.model.Assets;
import com.staxrt.tutorial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface User repository.
 *
 * @author Givantha Kalansuriya
 */
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Assets, Long> {}
