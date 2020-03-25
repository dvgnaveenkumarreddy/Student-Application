package com.student.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.student.demo.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByStudentNumber(Long studentNumber);

	Student findByEmail(String email);

	List<Student> findAllByOrderByGpa();

	void deleteById(Long studentNumber);


}
