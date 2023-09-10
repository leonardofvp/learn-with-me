package com.learn_with_me.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learn_with_me.jwt.JwtAutenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	 private final JwtAutenticationFilter jwtAuthenticationFilter;
	 
	 private final AuthenticationProvider authProvider;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		 return http
		            .csrf(csrf -> 
		                csrf
		                .disable())
		            .authorizeHttpRequests(authRequest ->
		              authRequest
		                .requestMatchers("/auth/**").permitAll()
		                .anyRequest().authenticated()
		                )
		            .sessionManagement(sessionManager->
		                sessionManager 
		                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		            .authenticationProvider(authProvider)
		            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
		            .build();
	}
}
	 

/*
 *  .requestMatchers("/auth/**").permitAll()
		                .requestMatchers("/notificacion/recibirEmail").permitAll()
		                .requestMatchers("/test/guardarTest/**").permitAll()
		                .anyRequest().authenticated()
		                
		                 .requestMatchers("/notificacion/recibirEmail").permitAll()
		                .requestMatchers("/test/guardarTest/**").permit
 * 
 * */
