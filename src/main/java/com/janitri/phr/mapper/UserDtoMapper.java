package com.janitri.phr.mapper;


import com.janitri.phr.dto.PatientDto;
import com.janitri.phr.dto.UserDto;
import com.janitri.phr.entity.Patient;
import com.janitri.phr.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface to handle convert User entity to DTO and vice versa
 */
@Mapper
public interface UserDtoMapper {
    UserDtoMapper INSTANCE = Mappers.getMapper( UserDtoMapper.class );

    UserDto userEntityToDto(User source);
    User userDtoToEntity(UserDto source);
}
