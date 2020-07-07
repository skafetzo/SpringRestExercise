package com.learning.ote.spring.mvc.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class HelloRepositoryImpl implements HelloRepository {

    private static Map<String, String> userMap = Map.of(
            "1", "Stelios",
            "2", "Yiannis",
            "3", "Grigoris",
            "4", "World");

    @Override
    public Optional<String> getUserFromId(String id) {
        return Optional.ofNullable(userMap.get(id));
    }

}
