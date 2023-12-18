package com.luschickij.criticine.criticines.service;

import com.luschickij.criticine.criticines.data.UserRepository;
import com.luschickij.criticine.criticines.model.User;
import com.luschickij.criticine.criticines.security.CritiCineUserDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CritiCineUserDetailsService implements UserDetailsService {

    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CritiCineUserDetails(user);
    }
}
