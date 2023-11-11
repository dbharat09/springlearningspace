package com.springlearning.springlearningspace.service;

import com.springlearning.springlearningspace.data.User;
import com.springlearning.springlearningspace.repository.LoginRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    LoginRepo loginRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = loginRepo.findByUserName(username);

        if(user != null){
            return User.builder()
                    .userName(username)
                    .password(user.getPassword())
                    .build();
        }else{
            throw new UsernameNotFoundException("User Not Found");
        }
    }
}
