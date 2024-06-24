package com.hemanth.config;

import com.hemanth.model.Authority;
import com.hemanth.model.Customer;
import com.hemanth.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class EasyBankUsernamePwdAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName=authentication.getName();
        String pwd=authentication.getCredentials().toString();



            List<Customer> customerList=customerRepository.findByEmail(userName);
            if(customerList.size()>0){
                if(passwordEncoder.matches(pwd,customerList.get(0).getPwd())){

                    return new UsernamePasswordAuthenticationToken(userName,pwd,getAuthorities(customerList.get(0).getAuthorities()));

                }else{
                    throw new BadCredentialsException("Password is invalid");

                }

            }else{
                throw new BadCredentialsException("User not found");
            }



    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    private  List<GrantedAuthority> getAuthorities(Set<Authority> authoritySet){
        List<GrantedAuthority>authorities=new ArrayList<>();
        for(Authority authority: authoritySet){
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return authorities;
    }
}
