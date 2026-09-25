package com.kritika.SpringSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // ye tumhare default flow ko rok dega
public class spring_config {

@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    // making the csrf disable
    http.csrf(customizer ->customizer.disable());
    // making the request authorized
    http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
    // making the password as by default
    http.formLogin(Customizer.withDefaults());
    return http.build();
}


}
