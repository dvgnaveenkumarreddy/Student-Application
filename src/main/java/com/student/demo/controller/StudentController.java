package com.student.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.demo.model.Student;
import com.student.demo.repo.StudentRepository;


@RestController
@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@RequestMapping("/")
	public @ResponseBody String hello() {
		return "Hello, Welcome to Student Application !";
	}
	
	@GetMapping("/all")
	public List<Student> getEmployee() {
		System.out.println(studentRepo.findById("10394991"));
		return studentRepo.findAll();
		
	}
	
	@PostMapping("/add")
	public List<Student> addEmployee(@Valid @RequestBody Student emp) {
		studentRepo.save(emp);
		return studentRepo.findAll();
	}
	
    @GetMapping(value = "/{studentNumber}")
    public Student getStudentByStudentNumber(@PathVariable("studentNumber") Long studentNumber) {
        return studentRepo.findByStudentNumber(studentNumber);
    }
	
    @GetMapping(value = "/{email}")
    public Student getStudentByEmail(@PathVariable("email") String email) {
        return studentRepo.findByEmail(email);
    }

    @GetMapping(value = "/orderByGpa")
    public List<Student> findAllByOrderByGpaDesc() {
        return studentRepo.findAllByOrderByGpa();
    }
    
    @DeleteMapping(value = "/{studentNumber}")
    public List<Student> deleteStudentById(@PathVariable("studentNumber") Long studentNumber) {
    	studentRepo.deleteById(studentNumber);
    	return studentRepo.findAll();
    }

 
    
    

}
