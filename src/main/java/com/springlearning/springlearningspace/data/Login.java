package com.springlearning.springlearningspace.data;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Builder
public class Login {

    private String userName;

    private String password;

    private String access_token;

}
