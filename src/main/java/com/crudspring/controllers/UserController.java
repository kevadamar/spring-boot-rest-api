package com.crudspring.controllers;

import javax.validation.Valid;

import com.crudspring.entities.User;
import com.crudspring.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * UserController
 */

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Object> index() {
        return userService.getListUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable("id") long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<Object> save(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }

}