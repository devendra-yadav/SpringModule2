package com.epam.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private int id;
	
	@NotNull(message="email can not be empty")
	@Column(name="email")
	@Email(message="not a valid email.")
	private String email;
	
	@Column(name="name")
	@NotNull(message="name can not be empty")
	private String name;
	
	@Column(name="birthday")
	@NotNull(message="birthday can not be empty")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Past(message="birthday can't be in future.")
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate birthDay;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String name, LocalDate birthDay) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.birthDay = birthDay;
	}
	
//	public User(int id, String email, String name, String birthDay) {
//		this.id = id;
//		this.email = email;
//		this.name = name;
//		this.birthDay = LocalDate.parse(birthDay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", birthDay=" + birthDay + "]";
	}
	
}
