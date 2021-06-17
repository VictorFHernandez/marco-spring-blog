package com.codeup.springblog.services;

import com.codeup.springblog.daos.UserRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserWithRoles;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final UserRepository users;

    public UserDetailsLoader(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = users.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + userName);
        }

        return new UserWithRoles(user);
    }
}