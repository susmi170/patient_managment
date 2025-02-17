package com.janitri.phr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Using lombok to generate getter setter and constructors
 * Entity class for PATIENT TABLE with below columns
 * ID,NAME,ADDRESS,DATEOFBIRTH,CHECKUPDATE,CREATEDBY,UPDATEDBY,HEARTRATE
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String address;
    @Column(name = "DATEOFBIRTH")
    private Date dateOfBirth;
    @Column(name = "CHECKUPDATE")
    private Date checkUpDate;
    private String status;
    @Column(name = "CREATEDBY")
    private String createdBy;
    @Column(name = "UPDATEDBY")
    private String updatedBy;
    @Column(name = "HEARTRATE")
    private int heartRate;


}
