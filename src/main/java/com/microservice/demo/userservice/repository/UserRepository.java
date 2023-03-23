package com.microservice.demo.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.demo.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByEmail(String email);
	User findByFirstname(String firstname);
	User findByLastname(String lastname);

}
