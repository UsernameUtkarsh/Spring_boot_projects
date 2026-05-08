package com.bharath.springboot.thymeleaf.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bharath.springboot.thymeleaf.model.Student;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/sendData")
	public ModelAndView sendData() {
		ModelAndView mav = new ModelAndView("data");
		mav.addObject("message","Take up one idea and make it your life");
		return mav;
			
	}
	@GetMapping("/student")
	public ModelAndView getStudent() {
		ModelAndView mav = new ModelAndView("student");
		Student student = new Student();
		student.setName("Bob");
		student.setScore(90);
		mav.addObject("student",student);
		return mav;
	}
	
	@GetMapping("/students")
	public ModelAndView getStudents() {
		ModelAndView mav = new ModelAndView("studentList");
		
		Student student = new Student();
		student.setName("Bob");
		student.setScore(90);
		
		Student student2 = new Student();
		student2.setName("Bob");
		student2.setScore(95);
		
		List<Student> students = Arrays.asList(student,student2);
		
		mav.addObject("students",students);
		return mav;
	}
	@GetMapping("/studentForm")
	public ModelAndView displayStudentForm() {
		ModelAndView mav = new ModelAndView("studentForm");
		Student student = new Student();
		student.setName("Bob");
		student.setScore(90);
		mav.addObject("student",student);
		return mav;
	}
	@GetMapping("/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		ModelAndView mav = new ModelAndView("result");
		System.out.println(student.getName());
		System.out.println(student.getScore());
		return mav;
	}

}
