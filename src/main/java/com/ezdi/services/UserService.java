package com.ezdi.services;

import com.ezdi.beans.User;
import com.ezdi.daos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by EZDI\ganesh.s on 13/7/16.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findOne(s);
        if( user == null ) {
            throw new UsernameNotFoundException("Unable to find a user with username " + s);
        }
        return new UserDetails(user);
    }
}
