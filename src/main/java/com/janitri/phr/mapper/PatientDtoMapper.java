package com.janitri.phr.mapper;


import com.janitri.phr.dto.PatientDto;
import com.janitri.phr.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface to handle convert Patient entity to DTO and vice versa
 */
@Mapper
public interface PatientDtoMapper {
    PatientDtoMapper INSTANCE = Mappers.getMapper( PatientDtoMapper.class );

    PatientDto patientEntityToDto(Patient source);
    Patient patientDtoToEntity(PatientDto source);
}
