package com.student.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.demo.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	User findByUserName(String userName);
	
	

	
}
