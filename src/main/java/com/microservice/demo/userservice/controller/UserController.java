package com.microservice.demo.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.userservice.model.User;
import com.microservice.demo.userservice.repository.UserRepository;

@RestController
@RequestMapping("/api/user")
public class UserController {
   @Autowired
   private UserRepository repository;
   
   @GetMapping(value="/findByEmail")
   public User getUserByEmail(@RequestParam String email) {
	   System.out.println("Here " + email);
      return repository.findByEmail(email);
   }
   
   @GetMapping(value="/findByFirstname")
   public User getUserByFirstname(@RequestParam String firstname) {
      return repository.findByFirstname(firstname);
   }
   @GetMapping(value="/findByLastname")
   public User getUserByLastname(@RequestParam String lastname) {
	  return repository.findByLastname(lastname);
   }
   
   @PostMapping("/insertNewUser")
	public ResponseEntity<User> createTutorial(@RequestBody User user) {
		try {
			User user1 = repository.save(user);
			return new ResponseEntity<>(user1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}