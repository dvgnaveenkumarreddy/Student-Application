package com.student.demo.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Students")
public class Student{

		@Id
		private String id;
		
		@NotBlank(message = "Name is mandatory")
	    @Size(min = 3, max = 25, message 
	    = "Name must be between 3 and 25 characters")
	    private String name;
		
		@NotNull(message = "Student Number is mandatory")
		@Indexed(unique = true)
	    private long studentNumber;
	    
	    @Email(message = "Email should be valid")
	    @Indexed(unique = true)
	    private String email;
	    
	    private List<String> courseList;
	    private float gpa;
	    
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getStudentNumber() {
			return studentNumber;
		}
		public void setStudentNumber(long studentNumber) {
			this.studentNumber = studentNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public List<String> getCourseList() {
			return courseList;
		}
		public void setCourseList(List<String> courseList) {
			this.courseList = courseList;
		}
		public float getGpa() {
			return gpa;
		}
		public void setGpa(float gpa) {
			this.gpa = gpa;
		}
		public Student(String id, String name, long studentNumber, String email, List<String> courseList, float gpa) {
			super();
			this.id = id;
			this.name = name;
			this.studentNumber = studentNumber;
			this.email = email;
			this.courseList = courseList;
			this.gpa = gpa;
		}
		
	    
	    
		
}
