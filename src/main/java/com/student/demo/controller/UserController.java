package com.student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.model.User;
import com.student.demo.repo.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/")
	public String helloUser(){
		return "In user Controller";
	}
	
	@PostMapping("/signup")
	public User createUser(@Validated @RequestBody User user ) throws Exception {
		User userData =userRepo.findByUserName(user.getUserName());
		if(userData == null) {
		userRepo.save(user);
		} else throw new Exception("Username already exists");
		return user;
	}
	

}
