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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rid;
	@Column(nullable = false,unique = true)
	private String role;
	@ManyToMany(mappedBy = "roleslist" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<User>userList=new ArrayList<>();

	public Role(Long rid, String role, List<User> userList) {
		super();
		this.rid = rid;
		this.role = role;
		this.userList = userList;
	}

	public Role() {
		
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	

	
	

}
