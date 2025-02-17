package com.janitri.phr.dao;

import com.janitri.phr.entity.Patient;
import com.janitri.phr.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

    <Optional>User findByEmail(String email);
}
