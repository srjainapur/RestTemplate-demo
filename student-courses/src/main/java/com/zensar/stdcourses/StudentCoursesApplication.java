package com.zensar.stdcourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentCoursesApplication.class, args);
	}

}

