package com.zensar.stdconsumer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.stdconsumer.model.Courses;
import com.zensar.stdconsumer.model.Student;

@RestController
public class StudentConsumerController {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Autowired
	public DiscoveryClient discoveryClient;
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") String stdId) {
		
		// Get Student Details
		//String url = getStudentUrl() + "/student/{stdId}";
		String url = getZuulURL() + "/student/student/{stdId}";
		
		
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("stdId", stdId);
		ResponseEntity<Student> forEntity = restTemplate.getForEntity(url, Student.class, uriVariables);
		Student student = forEntity.getBody();
		
		// Get Student Course Details
		List<Courses> cList = getCoursesList(stdId);
		System.out.println("List of Courses " + cList);
		student.setCourses(cList);
		return student;
	}
	
	private List<Courses> getCoursesList(String stdId) {
		//String cURL = getCoursesURL() + "/courses/"+stdId;
		String cURL = getZuulURL() + "/courses/courses/"+stdId;
		
		ArrayList<MediaType> list = new ArrayList<>();
		list.add(MediaType.APPLICATION_JSON);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(list);
		
		HttpEntity<String> reqEntity = new HttpEntity<String>(headers);
		ResponseEntity<List<Courses>> responseEntity = restTemplate.exchange(cURL, HttpMethod.GET, reqEntity, new ParameterizedTypeReference<List<Courses>>(){});
		System.out.println("responseEntity " + responseEntity);
		return responseEntity.getBody();
	}
	
	@PostMapping("/student")
	public Student insertStudent(@RequestBody Student student) {
		ResponseEntity<Student> postForEntity = restTemplate.postForEntity(getZuulURL() + "/student/student", student, Student.class);
		return postForEntity.getBody();
	}
	
	public String getStudentUrl() {
		List<ServiceInstance> instances = discoveryClient.getInstances("studentclient");
		ServiceInstance serviceInstance = instances.get(0);
		return "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort();
	}
	
	public String getCoursesURL() {
		List<ServiceInstance> instances = discoveryClient.getInstances("student-course");
		ServiceInstance serviceInstance = instances.get(0);
		return "http://" + serviceInstance.getHost()+ ":" + serviceInstance.getPort();
	}
	
	public String getZuulURL() {
		List<ServiceInstance> instances = discoveryClient.getInstances("student-api-gateway");
		ServiceInstance serviceInstance = instances.get(0);
		System.out.println("ZUUUUL URL " + "http://" + serviceInstance.getHost()+ ":" + serviceInstance.getPort());
		return "http://" + serviceInstance.getHost()+ ":" + serviceInstance.getPort();
	}
	
}
