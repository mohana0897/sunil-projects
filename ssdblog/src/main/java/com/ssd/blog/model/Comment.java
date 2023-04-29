package com.ssd.blog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	public Comment(Long id, String name, String email, Post post) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.post = post;
	}
	public Comment() {
		super();
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", name=" + name + ", email=" + email + ", post=" + post + "]";
	}

}
