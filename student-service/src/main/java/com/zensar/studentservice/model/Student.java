package com.zensar.studentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MIC_STUDENT_TAB")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 5, name = "STD_ID", nullable = false)
	private long studId;

	@Column(name = "FIRST_NAME", length = 25, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", length = 25)
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE_NUMBER")
	private int phoneNumber;

	@Column(name = "EMAIL")
	private String email;

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
