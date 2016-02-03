package com.benjamin.spring.web.dao;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class Offer {
	
	
	private int id;
	@NotNull(message= "Name cannot be empty")
	@Size(min=5,max=100,message="Name must be between 5 and 100 characters")
	private String name;
	

	@NotEmpty(message= "Email cannot be empty") @Email(message="Please type a valid email address")
	private String email;
	@NotNull
	@Size(min=20, max=225, message="Text must be between 20 and 255 characters")
	private String text;

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", email=" + email
				+ ", text=" + text + "]";
	}

	
	

}
