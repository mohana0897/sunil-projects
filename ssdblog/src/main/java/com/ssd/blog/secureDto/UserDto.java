package com.ssd.blog.secureDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDto {
	
private Long uid;
	
	private String name;
	@NotBlank(message = "Enter your email required")
	@Size(min = 5,message = "your email should be min 5 char")
	private String email;
	@NotBlank(message = "Enter your username required")
	private String username;
	@NotBlank(message = "Enter Password reqired")
	@Size(min = 5,message = "password must be min 5 chars")
	private String password;

	public UserDto(Long uid, String name, String email, String username, String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	public UserDto(String name, String email, String username, String password) {
		super();
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public UserDto() {
		super();
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
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
	@Override
	public String toString() {
		return "userDto [uid=" + uid + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
	

}
