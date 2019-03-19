package com.zensar.stdcourses.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.stdcourses.model.Courses;

@Service
public interface CourseService {

	Courses saveCourses(Courses courses);

	List<Courses> getCoursesById(Long cId);
}
