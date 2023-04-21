/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.example.GreenBone.SimpleCompany.controller;

import com.example.GreenBone.SimpleCompany.model.Assets;
import com.example.GreenBone.SimpleCompany.respository.Repository;
import com.example.GreenBone.SimpleCompany.exception.ResourceNotFoundException;
import com.example.GreenBone.SimpleCompany.model.Assets;
import com.example.GreenBone.SimpleCompany.respository.;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type User controller.
 *
 * @author Givantha Kalansuriya
 */
@RestController
@RequestMapping("/api/v1")
public class Controller {

  @Autowired
  private Repository userRepository;

  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/users")
  public List<Assets> getAllUsers() {
    return userRepository.findAll();
  }

  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws \ the resource not found exception
   */
  @GetMapping("/users/{id}")
  public ResponseEntity<Assets> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {
    Assets assets =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(assets);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/users")
  public Assets createUser(@Valid @RequestBody Assets asset) {
    return userRepository.save(user);
  }

  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/users/{id}")
  public ResponseEntity<Assets> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody Assets userDetails)
      throws ResourceNotFoundException {

    Assets user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

//    user.setEmail(userDetails.getEmail());
//    user.setLastName(userDetails.getLastName());
//    user.setFirstName(userDetails.getFirstName());
//    user.setUpdatedAt(new Date());
//    final User updatedUser = userRepository.save(user);
//    return ResponseEntity.ok(updatedUser);
  }

  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    Assets assets =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

    userRepository.delete(assets);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
