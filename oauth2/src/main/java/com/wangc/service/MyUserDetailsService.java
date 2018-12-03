package com.wangc.service;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author: gnehcgnaw
 * @date: 2018-12-02 13:20
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        if ("admin".equalsIgnoreCase(name)){
            User user = mockUser();
            return user ;
        }
        return null;
    }

    private User mockUser() {
        Collection<GrantedAuthority> grantedAuthorityCollection = new HashSet<>();
        grantedAuthorityCollection.add(new SimpleGrantedAuthority("admin"));
        User user = new User("admin",passwordEncoder().encode("123456"),grantedAuthorityCollection);
        return user ;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
