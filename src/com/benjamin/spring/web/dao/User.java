package com.benjamin.spring.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	
	@NotBlank(message ="Username cannot be blank.")
	@Size(min=5,max=15, message="Username must be between 5 and 15 characters long.")
	@Pattern(regexp="^\\w{5,}$", message = "Username can only consist of numbers, letters and the underscore charachter.")
	private String username;
	
	@NotBlank(message ="Password cannot be blank.")
	@Pattern(regexp="^\\S+$", message="password cannot contain spaces.")
	@Size(min = 8, max = 15, message="password must be between 8 and 15 characters long.")
	private String password;
	
	@Email(message = "This is not a valid email address.")
	private String email;
	private int enabled = 0;
	private String authority;

	public User() {

	}

	public User(String username, String password, String email,
			int enabled, String authority) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String suthority) {
		this.authority = suthority;
	}

}
