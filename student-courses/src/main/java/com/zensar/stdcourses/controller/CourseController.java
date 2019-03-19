package com.zensar.stdcourses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.stdcourses.model.Courses;
import com.zensar.stdcourses.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService cService;
	
	@PostMapping(value="/courses")
	public Courses insertCourses(@RequestBody Courses courses) throws JsonProcessingException {
		Courses saveCourses = cService.saveCourses(courses);
		//ObjectMapper mapper = new ObjectMapper();
		//return mapper.writeValueAsString(saveCourses);
		return saveCourses;
	}
	
	@GetMapping(value="/courses/{stdId}")
	public List<Courses> getCoursesById(@PathVariable("stdId") Long stdId) {
		return cService.getCoursesById(stdId);
	}
}
