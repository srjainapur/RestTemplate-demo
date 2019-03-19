package com.zensar.studentservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.studentservice.model.Student;
import com.zensar.studentservice.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	public StudentRepository stdrepository;
	
	@Override
	public Student getStudentById(Long stdId) {
		Optional<Student> stdOptional = stdrepository.findById(stdId);
		return stdOptional.get(); 
	}

	@Override
	public Student addStudent(Student student) {
		return stdrepository.save(student);
	}
}
