package com.example.training.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

@SuppressWarnings("serial")
public class Reservation implements Serializable {
	private String id;
	private String trainingId;
	private Training training;
	private String studentTypeId;
	private StudentType studentType;
    private LocalDateTime reservedDateTime;
    private String name;
    private String phone;
    private String emailAddress;


	public String getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}

	public String getStudentTypeId() {
		return studentTypeId;
	}

	public void setStudentTypeId(String studentTypeId) {
		this.studentTypeId = studentTypeId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public StudentType getStudentType() {
		return studentType;
	}

	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}

	public LocalDateTime getReservedDateTime() {
		return reservedDateTime;
	}

	public void setReservedDateTime(LocalDateTime reservedDateTime) {
		this.reservedDateTime = reservedDateTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
