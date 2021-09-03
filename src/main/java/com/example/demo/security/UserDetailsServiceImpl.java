package com.example.demo.security;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * finds a user by username and returns a Spring UserDetails object
 */

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    private Collection<? extends GrantedAuthority> getAuthorities(String... user) {
        List<GrantedAuthority> retVal = new ArrayList<>();
        Arrays.stream(user)
                .forEach(u -> retVal.add(new SimpleGrantedAuthority(u)));
        return retVal;
    }

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new Exception("User not found"));
        return new org.springframework.security
                .core.userdetails.User(user.getUsername(),
                user.getPassword(),
                true, true, true, true,
                this.getAuthorities("USER"));
    }
}
