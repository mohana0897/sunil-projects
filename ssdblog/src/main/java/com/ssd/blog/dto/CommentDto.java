package com.ssd.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDto {
	
	
	private Long id;
	@NotBlank(message = "name of the comment should required")
	private String name;
	@NotBlank(message = "email must required")
	@Size(min = 8,message = "your email should be min 8 characters")
	@Size(max = 25,message = "your email should not exceed 25 characters")
	private String email;
	

	public CommentDto() {
		super();
	}

	public CommentDto(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		
	}

	public CommentDto(String name, String email) {
		super();
		this.name = name;
		this.email = email;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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



	@Override
	public String toString() {
		return "CommentDto [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	

}
