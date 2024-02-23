package com.azati.study.springactuatordemo.management;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DbHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        if (isDbHealthy()) {
            return Health.up().withDetail("External DB status", "Healthy").build();
        }
        return Health.down().withDetail("External DB status", "Not healthy").build();
    }

    //mimics a call to external DB (or service)
    private boolean isDbHealthy(){
        Random random = new Random();
        return random.nextBoolean();
    }
}
