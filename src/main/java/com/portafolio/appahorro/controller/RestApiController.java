package com.portafolio.appahorro.controller;

import com.portafolio.appahorro.repository.UserRepository;
import com.portafolio.appahorro.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class RestApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("test1")
    public String test1(){
        return "API test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API test 2";
    }

    @GetMapping("users")
    public List<User> users(){
        return userRepository.findAll();
    }
}
