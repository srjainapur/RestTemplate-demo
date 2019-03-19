package com.zensar.stdcourses.service;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.stdcourses.model.Courses;
import com.zensar.stdcourses.repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseRepository cRepository;
	
	@Override
	public Courses saveCourses(Courses courses) {
		// TODO Auto-generated method stub
		return cRepository.save(courses);
	}

	@Override
	public List<Courses> getCoursesById(Long stdId) {
		return cRepository.findCourseByStdId(stdId);
	}
}
