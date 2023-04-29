
package com.ssd.blog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PostDto {
	
	
	private Long id;
	@NotBlank(message ="valid title is required")
	@Size(min =3,message = "your title should be minimum 3 characters")
	@Size(max = 15,message = "your title shold be maximum 15 characters")
	private String title;
	@NotBlank(message ="post description is required")
	private String description;
	@NotBlank(message ="post content is required")
	private String content;
	
	



	public PostDto() {
		super();
	}

	public PostDto(String title, String description, String content) {
		super();
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public PostDto(Long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content + "]";
	}
	
	
	

}
