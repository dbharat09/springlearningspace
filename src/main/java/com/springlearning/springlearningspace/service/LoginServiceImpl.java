package com.springlearning.springlearningspace.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springlearning.springlearningspace.data.Login;
import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.repository.LoginRepo;
import lombok.RequiredArgsConstructor;
import lombok.var;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements  LoginService{

    public final LoginRepo loginRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    public User userAuthenticate(Login userLogin) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userLogin.getUserName(),
                            userLogin.getPassword())
            );
        }catch (Exception e){
           throw new Exception("Failure reason - " + e.getMessage());
        }


        var user = loginRepo.findByUserName(userLogin.getUserName());

        var jwtToken = jwtService.generateToken(user);

        tokenService.saveToken(user, jwtToken);

        return User
                .builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(userLogin.getUserName())
                .access_token(jwtToken)
                .build();

    }

    @Override
    public List<User> getUser() throws JsonProcessingException {
        List<User> userDetails = loginRepo.findAll();
        ObjectMapper objectMapper = new ObjectMapper();

        // Convert the list to JSON
        String json = objectMapper.writeValueAsString(userDetails);
        return userDetails;
    }

    @Override
    public User registerUser(User registerUser) throws Exception {
        User saveUser = User.builder()
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .userName(registerUser.getUserName())
                .password(passwordEncoder.encode(registerUser.getPassword()))
                .build();

        try {
            User registeredUser = loginRepo.save(saveUser);
        }catch (Exception e){
           System.out.println(e.getMessage());
           throw new Exception(e.getMessage());
        }

        String jwtToken = jwtService.generateToken(saveUser);

        tokenService.saveToken(saveUser, jwtToken);
        return User
                .builder()
                .firstName(registerUser.getFirstName())
                .lastName(registerUser.getLastName())
                .userName(registerUser.getUserName())
                .access_token(jwtToken)
                .build();

    }

    @Override
    public User getUserByName(String userName) {

        return loginRepo.findByUserName(userName);

    }


}
