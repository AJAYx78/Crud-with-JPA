package com.example.crud1.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_details")
public class StudentModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Column(name = "student_id")
	private int id;
	@Column(name= "student_name")
	private String name;
	@Column(name = "student_course")
	private String course;
	@Column(name = "student_address")
	private String address;
	@Column(name= "student_email")
	private String email;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", course=" + course + ", address=" + address + ", email="
				+ email + "]";
	}
	
	

}
