package com.ssd.blog.secureDto;

public class RoleDto {
	
	private Long rid;
	private String role;
	public RoleDto(Long rid, String role) {
		super();
		this.rid = rid;
		this.role = role;
	}
	public RoleDto(String role) {
		super();
		this.role = role;
	}
	public RoleDto() {
		super();
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
	@Override
	public String toString() {
		return "RoleDto [rid=" + rid + ", role=" + role + "]";
	}
	

}
