package com.springlearning.springlearningspace.repository;

import com.springlearning.springlearningspace.data.UserToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TokenRepo extends MongoRepository<UserToken , String> {
}
