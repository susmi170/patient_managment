package com.janitri.phr.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Using lombok to generate getter setter and constructors
 * Entity class for USER TABLE with below columns
 * ID,NAME,PASSWORD,PHONE,EMAIL
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String password;

    private int phone;
    private String email;


}
