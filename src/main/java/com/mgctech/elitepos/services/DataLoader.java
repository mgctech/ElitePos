package com.mgctech.elitepos.services;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgctech.elitepos.model.User;
import com.mgctech.elitepos.repository.UserRepository;

@Service
public class DataLoader {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDatabase() {

        userRepository.deleteAll();

        PasswordEncoder passwordEncoder = (PasswordEncoder) new BCryptPasswordEncoder();

        User user = new User();
        user.setUsername("al@bigal73.com");
        user.setPassword(((BCryptPasswordEncoder) passwordEncoder).encode("blackburn"));
        user.setEnabled(true);
        user.setAccountNotExpired(true);
        user.setAccountNotLocked(true);
        user.setCredentialsNotExpired(true);
        user.addRole("ROLE_USER");
        user.addRole("ROLE_ADMIN");

        userRepository.save(user);

    }

}
