package com.janitri.phr.service;

import com.janitri.phr.constants.PatientManagmentConstant;
import com.janitri.phr.dao.PatientDAO;
import com.janitri.phr.dao.UserDAO;
import com.janitri.phr.dto.PatientDto;
import com.janitri.phr.dto.UserDto;
import com.janitri.phr.entity.Patient;
import com.janitri.phr.entity.User;
import com.janitri.phr.exception.PatientMonitorException;
import com.janitri.phr.exception.PatientNotFoundException;
import com.janitri.phr.exception.UserCredentailException;
import com.janitri.phr.exception.UserNotFoundException;
import com.janitri.phr.mapper.PatientDtoMapper;
import com.janitri.phr.mapper.UserDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    UserDtoMapper USER_MAPPER = UserDtoMapper.INSTANCE;

    /**
     * This method is dedicated to login user by email from DB
     * If patient not found will throw PatientNotFoundException
     *
     * @param userDto
     * @return
     * @throws PatientNotFoundException
     */
    public UserDto login(UserDto userDto) throws UserNotFoundException, UserCredentailException {
        Optional<User> patientOptional = userDAO.findByEmail(userDto.getEmail());

        User user = patientOptional.orElseThrow(() -> new UserNotFoundException(PatientManagmentConstant.USER_NOT_FOUND + "" + userDto.getEmail()));
        if (!userDto.getPassword().equals(user.getPassword()))
            throw new UserCredentailException(PatientManagmentConstant.USER_INCORRECT_PASSWORD);
        return USER_MAPPER.userEntityToDto(user);


    }

    /**
     * This method is dedicated to create a user with email and password in DB
     *
     * @param userDto
     * @return
     */
    public UserDto register(UserDto userDto) {

        return USER_MAPPER.userEntityToDto(userDAO.save(USER_MAPPER.userDtoToEntity(userDto)));


    }

}
