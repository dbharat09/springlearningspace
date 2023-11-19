package com.springlearning.springlearningspace.service;

import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.data.UserToken;
import com.springlearning.springlearningspace.repository.TokenRepo;
import lombok.var;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepo tokenRepo;

    public void saveToken(User user, String userToken) {
        var token = UserToken.builder()
                .userName(user.getUserName())
                .access_token(userToken)
                .build();
        tokenRepo.save(token);

    }
}
