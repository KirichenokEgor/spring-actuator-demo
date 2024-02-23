package com.azati.study.springactuatordemo.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class CustomWebConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) ->
                        authz.requestMatchers(EndpointRequest.to(HealthEndpoint.class)).permitAll()
                                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                )
                .csrf(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

}
