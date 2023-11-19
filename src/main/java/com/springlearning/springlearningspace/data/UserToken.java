package com.springlearning.springlearningspace.data;

import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "userToken")
@Builder
@Data
public class UserToken {

    @Id
    @GeneratedValue
    private String id;
    private String userName;
    private String access_token;
}
