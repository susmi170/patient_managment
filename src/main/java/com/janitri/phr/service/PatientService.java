package com.janitri.phr.service;

import com.janitri.phr.constants.PatientManagmentConstant;
import com.janitri.phr.dao.PatientDAO;

import com.janitri.phr.dto.PatientDto;
import com.janitri.phr.entity.Patient;
import com.janitri.phr.exception.PatientMonitorException;
import com.janitri.phr.exception.PatientNotFoundException;
import com.janitri.phr.mapper.PatientDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    PatientDAO patientDAO;
    PatientDtoMapper PATIENT_MAPPER = PatientDtoMapper.INSTANCE;

    /**
     * This method is dedicated to get a patient by a id from DB
     * If patient not found will throw PatientNotFoundException
     *
     * @param id
     * @return
     * @throws PatientNotFoundException
     */
    public PatientDto getPatientById(int id) throws PatientNotFoundException {
        Optional<Patient> patientOptional = patientDAO.findById(id);
        Patient patient = patientOptional.orElseThrow(() -> new PatientNotFoundException(PatientManagmentConstant.PATIENT_NOT_FOUND + "" + id));
        return PatientDtoMapper.INSTANCE.patientEntityToDto(patient);


    }

    /**
     * This method used to get all the patients available in DB
     * If patient not found will throw PatientNotFoundException
     *
     * @return
     * @throws PatientNotFoundException
     */
    public List<PatientDto> getAllPatients() throws PatientNotFoundException {
        Iterable<Patient> patients = patientDAO.findAll();
        List<PatientDto> patientDtoList = new ArrayList<>();
        for (Patient patient : patients) {
            PatientDto patientDto = PATIENT_MAPPER.patientEntityToDto(patient);
            patientDtoList.add(patientDto);
        }
        if (patientDtoList.size() == 0)
            throw new PatientNotFoundException(PatientManagmentConstant.PATIENTS_NOT_FOUND);
        return patientDtoList;
    }

    /**
     * This used to save a patient in DB with given patient details
     *
     * @param patientDto
     * @return
     */
    public PatientDto savePatient(PatientDto patientDto) throws PatientMonitorException {
        try {
            Patient patientEntity = PatientDtoMapper.INSTANCE.patientDtoToEntity(patientDto);
            Patient patient = patientDAO.save(patientEntity);
            return PatientDtoMapper.INSTANCE.patientEntityToDto(patient);
        } catch (Exception exception) {
            throw new PatientMonitorException(" Patient Management exception");
        }
    }

    /**
     * This method is dedicated to update a patient by the patient details passed to the method.
     * In case the patient not found in DB it will throw PatientNotFoundException
     *
     * @param patientDto
     * @return
     * @throws PatientNotFoundException
     */
    public PatientDto updatePatient(PatientDto patientDto) throws PatientNotFoundException, PatientMonitorException {
        getPatientById(patientDto.getId());
        return savePatient(patientDto);

    }

    /**
     * This method is to delete a patient by id ,
     * In case patient not found in DB it throw exception .
     * if patient available or not then we can call get patient first and then if found proceed further.
     * If not found then throw exception
     *
     * @param id
     * @return
     */
    public String deletePatient(int id) throws PatientNotFoundException {
        getPatientById(id);
        patientDAO.deleteById(id);
        return PatientManagmentConstant.PATIENT_DELETED_SUCCESS + " ID :" + id;

    }
}
