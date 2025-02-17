package com.janitri.phr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Using lombok to generate getter setter and constructors
 * DTO class corresponding to User entity class
 * Any data passing to and from controller will use this DTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "Id is mandatory")

    private int id;
    @NotBlank(message = "Name is mandatory")

    private String name;

    @NotBlank(message = "Email is mandatory")

    private String email;

    @NotBlank(message = "Phone  is mandatory")

    private String phone;

    @NotBlank(message = "password  is mandatory")

    private String password;

    public UserDto( String name, String email, String phone, String password) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
}
