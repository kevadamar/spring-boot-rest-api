package com.crudspring.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.crudspring.entities.User;
import com.crudspring.repository.UserRepository;
import com.crudspring.response.ResponseHandler;
import com.crudspring.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Object> getListUser() {
        try {
            List<User> result = userRepository.findAll();
            return ResponseHandler.generateResponse("Successfully retrieved data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> getUser(long id) {
        try {
            HttpStatus status = HttpStatus.OK;
            String msg = "Successfully retrieved data!";
            Optional<User> result = userRepository.findById(id);

            if (!result.isPresent()) {
                status = HttpStatus.NOT_FOUND;
                msg = "Record Not Found";
            }

            return ResponseHandler.generateResponse(msg, status, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> saveUser(User user) {
        try {
            HttpStatus status = HttpStatus.OK;
            String msg = "Successfully created data!";
            User result = userRepository.save(user);

            if (result.equals(null)) {
                status = HttpStatus.NOT_FOUND;
                msg = "Failed created data!";
            }

            return ResponseHandler.generateResponse(msg, status, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> deleteUser(Long id) {
        try {
            HttpStatus status = HttpStatus.OK;
            String msg = "Successfully deleted data!";
            Optional<User> result = userRepository.findById(id);

            if (!result.isPresent()) {
                status = HttpStatus.NOT_FOUND;
                msg = "Record Not Found";
                return ResponseHandler.generateResponse(msg, status, result);
            }

            userRepository.deleteById(id);
            
            return ResponseHandler.generateResponse(msg, status, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

}
