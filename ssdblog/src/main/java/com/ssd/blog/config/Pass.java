package com.ssd.blog.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Pass {

	public static void main(String[] args) {
		
		
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	System.out.println(	passwordEncoder.encode("sarma"));
		
		
	}
	
}
