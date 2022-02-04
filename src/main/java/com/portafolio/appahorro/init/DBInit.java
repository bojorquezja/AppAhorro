package com.portafolio.appahorro.init;

import com.portafolio.appahorro.repository.UserRepository;
import com.portafolio.appahorro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        List<User> newUsers = Arrays.asList(
                        new User("dan", passwordEncoder.encode("123"), "USER", ""),
                        new User("admin",  passwordEncoder.encode("123"), "ADMIN", "")
                );
        userRepository.saveAll(newUsers) ;

    }
}
