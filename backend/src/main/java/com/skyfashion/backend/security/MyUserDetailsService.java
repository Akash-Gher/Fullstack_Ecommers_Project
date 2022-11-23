package com.skyfashion.backend.security;


import com.skyfashion.backend.entity.User;
import com.skyfashion.backend.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // (1)
        User user = userRepo.findByName(username);
        if (user == null) throw new UsernameNotFoundException("User not found");

        return new MyUserDetails(user);
    }
}
