package com.springlearning.springlearningspace.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/springlearning")
public class TestController {

    @Autowired
    LoginService loginService;

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUser() throws JsonProcessingException {


        List<User> response = loginService.getUser();

        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
