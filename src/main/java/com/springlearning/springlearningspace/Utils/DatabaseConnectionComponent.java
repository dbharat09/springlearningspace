package com.springlearning.springlearningspace.Utils;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseConnectionComponent {

    @Autowired
    private EntityManager entityManager;

    public boolean isConnectionHealthy() {
        try {
            // Execute a simple query to check the database connectivity
            entityManager.createNativeQuery("SELECT * from user_login").getSingleResult();
            return true; // If successful, the connection is healthy
        } catch (Exception e) {
            return false; // If an exception occurs, the connection is not healthy
        }
    }
}

