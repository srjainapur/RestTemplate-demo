package com.zensar.stdcourses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIC_STD_COURSES")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cId;

	@Column(name = "COURSE_NAME", length = 50)
	private String courseName;

	@Column(name = "DURATION", length = 5)
	private String duration;

	@Column(name = "TRAINER", length = 50)
	private String trainer;
	
	@Column(name="STD_ID")
	private Long stdId;

	public Long getStdId() {
		return stdId;
	}

	public void setStdId(Long stdId) {
		this.stdId = stdId;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

}
