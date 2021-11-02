package com.crudspring.services;

import com.crudspring.entities.User;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<Object> getListUser();
    ResponseEntity<Object> getUser(long id);
    ResponseEntity<Object> saveUser(User user);
    ResponseEntity<Object> deleteUser(Long id);
}
