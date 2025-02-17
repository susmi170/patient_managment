package com.janitri.phr.dao;

import com.janitri.phr.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDAO extends CrudRepository<Patient, Integer> {
}
