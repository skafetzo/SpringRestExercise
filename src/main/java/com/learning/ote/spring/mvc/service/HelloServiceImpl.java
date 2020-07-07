package com.learning.ote.spring.mvc.service;

import com.learning.ote.spring.mvc.repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloServiceImpl implements HelloService{

    @Autowired
    private HelloRepository repository;

    @Override
    public String getUsernameFromId(String id) {

         Optional<String> username = repository.getUserFromId(id);

         return username.orElse("unknown user");

    }
}
