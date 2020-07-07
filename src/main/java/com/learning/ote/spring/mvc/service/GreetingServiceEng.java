package com.learning.ote.spring.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceEng implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello";
    }
}
