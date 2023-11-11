package com.springlearning.springlearningspace.repository;

import com.springlearning.springlearningspace.data.Login;
import com.springlearning.springlearningspace.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}
