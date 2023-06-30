package ru.bwforum.mark.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {


   @Bean
   public SecurityWebFilterChain config(ServerHttpSecurity http) {
       http
               .csrf()
               .disable()
               .authorizeExchange()
               .anyExchange()
               .permitAll();

       return http.build();
   }
}
