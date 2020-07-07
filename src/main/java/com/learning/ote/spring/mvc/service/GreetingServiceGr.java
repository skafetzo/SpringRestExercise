package com.learning.ote.spring.mvc.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GreetingServiceGr implements GreetingService {
    @Override
    public String getGreeting() {
        return "Γειά σου";
    }
}
