package com.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudspring.entities.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
