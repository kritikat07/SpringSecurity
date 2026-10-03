package com.kritika.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // ye tumhare default flow ko rok dega
public class spring_config {

    //@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//    // making the csrf disable
//    http.csrf(customizer ->customizer.disable());
//    // making the request authorized
//    http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//    // making the password as by default
//    http.formLogin(Customizer.withDefaults());
//    // agr hume iss chiz ka output postman me dikhana ho to kya ye likhenge
//    http.httpBasic(Customizer.withDefaults());
//
//
//    return http.build();
//}
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User
//                           .withDefaultPasswordEncoder()
//                           .username("kiran")
//                           .password("k@123")
//                           .roles("USER")
//                           .build();
//        UserDetails user2= User
//                .withDefaultPasswordEncoder()
//                .username("harsh")
//                .password("h@123")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider(
            UserDetailsService userDetailsService) {

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(userDetailsService);

        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());

        return provider;
    }
}


