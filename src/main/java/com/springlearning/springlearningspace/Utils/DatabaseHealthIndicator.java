package com.springlearning.springlearningspace.Utils;

import jakarta.persistence.EntityManager;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DatabaseHealthIndicator implements HealthIndicator {

    @Autowired
    private DatabaseConnectionComponent databaseConnectionComponent;

    @Override
    public Health health() {
        if (isDatabaseConnectionHealthy()) {
            return Health.up().build();
        } else {
            return Health.down().build();
        }
    }

    private boolean isDatabaseConnectionHealthy() {
        try {
            // Check the database connection here using databaseConnectionComponent
            // Return true if the connection is successful, or false if there's an issue
            // You can also use exceptions or other criteria to determine health
            return databaseConnectionComponent.isConnectionHealthy();
        } catch (Exception e) {
            return false;
        }
    }
}
