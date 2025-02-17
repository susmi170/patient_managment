package com.janitri.phr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * Using lombok to generate getter setter and constructors
 * DTO class corresponding to Patient entity class
 * Any data passing to and from controller will use this DTO.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    @NotNull(message = "Id is mandatory")

    private int id;
    @NotBlank(message = "Name is mandatory")

    private String name;
    @NotBlank(message = "Address is mandatory")

    private String address;

    @NotNull(message = "Date of birth is mandatory")

    private Date dateOfBirth;
    @NotNull(message = "Check up Date is mandatory")

    private Date checkUpDate;
    private String createdBy;
    private String updatedBy;

    @NotNull(message = "heart rate is mandatory")

    private Date heartRate;

    public PatientDto(String name, String address, Date dateOfBirth, Date checkUpDate, String createdBy, String updatedBy, Date heartRate) {
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.checkUpDate = checkUpDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.heartRate = heartRate;
    }
}
