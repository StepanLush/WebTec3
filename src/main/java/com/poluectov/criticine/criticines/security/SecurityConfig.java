package com.poluectov.criticine.criticines.security;

import com.poluectov.criticine.criticines.data.UserRepository;
import com.poluectov.criticine.criticines.service.CritiCineUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig{
    UserRepository userRepository;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/app", "/app/register", "/app/m/movie").permitAll()
                        .requestMatchers("/app/m/create").hasRole("ADMIN")
                        .requestMatchers("/app/critics").hasRole("ADMIN")
                        .anyRequest().denyAll()
                )
                .formLogin((form) -> form
                        .loginPage("/app/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CritiCineUserDetailsService(userRepository);
    }

}
