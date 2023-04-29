package com.ssd.blog.secureDto;

public class LoginDto {

	private String username;
	private String pwd;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public LoginDto(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}

	public LoginDto() {
		super();
	}

	@Override
	public String toString() {
		return "LoginDto [username=" + username + ", pwd=" + pwd + "]";
	}

}
