package com.example.mvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager theUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        theUserDetailsManager.setUsersByUsernameQuery("select username, password, active from employees where " +
                "username=?");
        theUserDetailsManager.setAuthoritiesByUsernameQuery("select username, role from employees where username=?");
        return theUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer -> configurer
                        .requestMatchers("/").hasAnyRole("EMPLOYEE", "MANAGER")
                        .requestMatchers("/listEmployees").hasRole("MANAGER")
                        .anyRequest().authenticated())
                .exceptionHandling(httpSecurityExceptionHandlingConfigurer ->
                        httpSecurityExceptionHandlingConfigurer.accessDeniedPage("/access-denied"))
                .formLogin(form -> form
                            .loginPage("/LoginPage")
                            .loginProcessingUrl("/authenticateTheUser")
                            .permitAll())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }
}