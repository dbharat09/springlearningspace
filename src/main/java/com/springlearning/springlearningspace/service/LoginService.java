package com.springlearning.springlearningspace.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springlearning.springlearningspace.data.Login;
import com.springlearning.springlearningspace.data.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    User userAuthenticate(Login userLogin) throws Exception;

    List<User> getUser() throws JsonProcessingException;

    User registerUser(User registerUser) throws Exception;

    User getUserByName(String userName);

}
