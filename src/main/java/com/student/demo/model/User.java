package com.student.demo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class User {
	
	@Id
	private String id;
	
	@NotBlank
	@Indexed(unique = true, dropDups = true)
	private String userName;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email(message = "Email should be valid")
    @Indexed(unique = true)
	private String email;
	
	
	
	public User(String id, String userName, String password, @Email(message = "Email should be valid") String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
