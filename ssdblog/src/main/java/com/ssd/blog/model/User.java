package com.ssd.blog.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long uid;
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false,unique = true)
	private String username;
	@Column(nullable = false,unique = true)
	private String password;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	         joinColumns= {@JoinColumn(name="uid")},
	         inverseJoinColumns = {@JoinColumn(name="rid")})
	@JsonIgnore
	private List<Role>roleslist=new ArrayList<>();

	public User(Long uid, String name, String email, String username, String password, List<Role> roleslist) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roleslist = roleslist;
	}

	public User() {
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

	public List<Role> getRoleslist() {
		return roleslist;
	}

	public void setRoleslist(List<Role> roleslist) {
		this.roleslist = roleslist;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", roleslist=" + roleslist + "]";
	}

	
	

	
}
