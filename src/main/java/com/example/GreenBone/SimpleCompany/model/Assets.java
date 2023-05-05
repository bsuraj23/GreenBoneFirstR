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
//package com.example.GreenBone.SimpleCompany.model;
//import lombok.Getter;
//import lombok.Setter;
//import jakarta.persistence.*;
//import org.hibernate.annotations.CreationTimestamp;
//
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//
//import java.util.Date;
//
///**
// * The type User.
// *
// * @author Givantha Kalansuriya
// */
//@Getter
//@Setter
//@Entity
//@Table(name = "assets")
//@EntityListeners(AuditingEntityListener.class)
//public class Assets {
//
//    @jakarta.persistence.Id
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
//
//    @Column(name = "mac_address ", nullable = false)
//    private String mac_address;
//
//    @Column(name = "computer_name ( ", nullable = false)
//    private String computer_name;
//    @Column(name = "ip_address ", nullable = false)
//    private String ip_address;
//
//    @Column(name = "employee_abbreviation ", nullable = false)
//    private String employee_abbreviation;
//
//    @Column(name = "description ", nullable = false)
//    private String description;
//
//
//
//
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", mac_address='" + mac_address + '\'' +
//                ", computer_name='" + computer_name + '\'' +
//                ", ip_address='" + ip_address + '\'' +
//                ", employee_abbreviation=" + employee_abbreviation +
//                ", description='" + description + '\'' +
//
//                '}';
//    }
//
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getId() {
//        return id;
//    }
//}
