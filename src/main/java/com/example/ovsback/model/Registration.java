package com.example.ovsback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	private String name,email,mobileno,password;
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Registration(String name, String email, String mobileno, String password) {
		super();
		this.name = name;
		this.email = email;
		this.mobileno = mobileno;
		this.password = password;
		
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

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}