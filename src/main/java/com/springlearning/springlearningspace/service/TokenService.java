package com.springlearning.springlearningspace.service;

import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.data.UserToken;
import org.springframework.stereotype.Service;

@Service
public interface TokenService {

    void saveToken(User user, String userToken);
}
