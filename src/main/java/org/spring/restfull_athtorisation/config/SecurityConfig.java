package org.spring.restfull_athtorisation.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    final CustomUserDetailsService customUserDetailsService;
    @Bean
    SecurityFilterChain defolterSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth->auth
                .requestMatchers("/api/public", "/api/create-account").permitAll()
                .requestMatchers("/api/all-roles").authenticated()
                .requestMatchers("/api/user").hasRole("USER")
                .requestMatchers("/api/admin").hasRole("ADMIN")
                .requestMatchers("/api/admin-moderator").hasAnyRole("MODERATOR", "ADMIN")

        );
        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic();


        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
