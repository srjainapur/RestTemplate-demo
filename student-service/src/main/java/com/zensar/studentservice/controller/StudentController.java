package com.zensar.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zensar.studentservice.model.Student;
import com.zensar.studentservice.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(path="/student/{stdId}", method=RequestMethod.GET)
	public Student getStudentById(@PathVariable("stdId") Long stdId) throws JsonProcessingException {
		Student student = studentService.getStudentById(stdId);
		//ObjectMapper mapper = new ObjectMapper();
		//return mapper.writeValueAsString(student);
		return student;
	}
	
	@RequestMapping(path="/student", method=RequestMethod.POST)
	public Student addStudent(@RequestBody Student student) throws JsonProcessingException {
		Student addStudent = studentService.addStudent(student);
		//ObjectMapper mapper = new ObjectMapper();
		//return mapper.writeValueAsString(addStudent);
		return addStudent;
	}
}
