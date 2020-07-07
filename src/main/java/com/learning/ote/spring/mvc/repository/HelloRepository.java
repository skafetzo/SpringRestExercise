package com.learning.ote.spring.mvc.repository;

import java.util.Optional;

public interface HelloRepository {

    public Optional<String> getUserFromId(String id);

}
