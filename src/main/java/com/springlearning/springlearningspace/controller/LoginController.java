package com.springlearning.springlearningspace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springlearning.springlearningspace.Utils.exception.MyCustomException;
import com.springlearning.springlearningspace.data.Login;
import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/springlearning/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody Login userLogin) throws Exception {

        try{
            User response = loginService.userAuthenticate(userLogin);

            return new ResponseEntity<>(response , HttpStatus.OK);
        }catch (Exception e){
            throw new MyCustomException(e.getMessage());
        }

    }

    @PostMapping("/Register")
    public ResponseEntity<User> register(@RequestBody User userRegister) throws Exception {

        try {
            User response = loginService.registerUser(userRegister);
            return new ResponseEntity<>(response , HttpStatus.OK);
        } catch (Exception e){
            throw new MyCustomException(e.getMessage());
        }

    }


}
