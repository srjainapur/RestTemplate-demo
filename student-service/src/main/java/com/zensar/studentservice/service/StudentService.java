package com.zensar.studentservice.service;

import org.springframework.stereotype.Service;

import com.zensar.studentservice.model.Student;

@Service
public interface StudentService {

	public Student getStudentById(Long stdId);

	public Student addStudent(Student student);
}
