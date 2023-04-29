package com.ssd.blog.secureService;

import java.util.ArrayList;

import java.util.List;

import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssd.blog.exception.MyBlogException;
import com.ssd.blog.jwtutil.JwtAuthProvider;
import com.ssd.blog.model.Role;
import com.ssd.blog.model.User;
import com.ssd.blog.secureDto.LoginDto;
import com.ssd.blog.secureDto.RegisterDto;
import com.ssd.blog.secureRepo.RoleRepository;
import com.ssd.blog.secureRepo.UserRepository;

@Service
public class UserSecureService {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RoleRepository repository2;
	
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtAuthProvider authProvider;
	
	public UserSecureService(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}


	public String userLogin(LoginDto dto) {
		Authentication authentication= (Authentication) authenticationManager.authenticate(

				new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPwd()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		if(authentication.isAuthenticated()) {
			return authProvider.generateToken(dto.getUsername());
		}else {
			 throw new MyBlogException("invalid username or pwd", HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	public String registerUser(RegisterDto dto) {
		User user=new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(encoder.encode(dto.getPassword()));
		user.setUsername(dto.getUsername());
		
		
	Role rs=repository2.findByRole("ADMIN").get();
		
//		Role rs=new Role();
//		rs.setRid(1L);
//	Role rs1=new Role();
//		rs1.setRid(2L);
//		
	List<Role>rolesList=new ArrayList<>();
	rolesList.add(rs);
//		rolesList.add(rs);
//	rolesList.add(rs1);
//		
		user.setRoleslist(rolesList);
		repository.save(user);
		
		return "Rgistration successfully completed";
		
	}

}
