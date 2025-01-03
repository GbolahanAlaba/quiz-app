package com.entacrest.QuizApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity (in production, configure properly)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/api/v1/user/register").permitAll()  // Allow access to /register
                                .anyRequest().authenticated()  // Secure other endpoints
                )
                .httpBasic();  // Enable basic authentication for other endpoints

        return http.build();
    }
}
