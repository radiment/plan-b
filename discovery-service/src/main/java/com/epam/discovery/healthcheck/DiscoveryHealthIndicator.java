package com.epam.discovery.healthcheck;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

@Component
public class DiscoveryHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        Status roleServiceStatus = Status.UP;

        StringJoiner description = new StringJoiner(", ");
        description.setEmptyValue("Everything is OK!");

        return Health.status(roleServiceStatus)
                .withDetail("description", description.toString())
                .build();
    }

}
