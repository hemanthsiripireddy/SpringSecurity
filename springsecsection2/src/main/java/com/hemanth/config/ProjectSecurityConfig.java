package com.hemanth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean

    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

//        http.authorizeHttpRequests((requests)->requests.
//                requestMatchers("/myAccounts","/myBalance","/myCards","/myLoans").authenticated()
//                .requestMatchers("/notices","/contacts").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//        http.authorizeHttpRequests((requests)->requests.anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
        http.authorizeHttpRequests((requests)->requests.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();

    }
}
