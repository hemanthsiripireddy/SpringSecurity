package com.hemanth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class ProjectSecurityConfig {

    @Bean

    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf)->csrf.disable())
                .authorizeHttpRequests((requests)->requests.
                requestMatchers("/myAccounts","/myBalance","/myCards","/myLoans").authenticated()
                .requestMatchers("/notices","/contacts","/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
        return http.build();
//        http.authorizeHttpRequests((requests)->requests.anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
//        return http.build();
//        http.authorizeHttpRequests((requests)->requests.anyRequest().permitAll())
//                .formLogin(Customizer.withDefaults())
//                .formLogin(Customizer.withDefaults());
      //  return http.build();

    }
//@Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
