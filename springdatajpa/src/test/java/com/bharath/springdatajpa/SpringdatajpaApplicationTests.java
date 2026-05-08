package com.bharath.springdatajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bharath.springdatajpa.entities.Student;
import com.bharath.springdatajpa.repos.StudentRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	private StudentRepository repository;

	@Test
	public void testSaveStudent() {
		Student student = new Student();
		student.setId(1l);
		student.setName("Bharath");
		student.setTestScore(100);
		repository.save(student);

		Student savedStudent = repository.findById(1l).get();
		assertNotNull(savedStudent);

	}

}
