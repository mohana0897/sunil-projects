package com.ssd.blog.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.secureDto.LoginDto;
import com.ssd.blog.secureDto.RegisterDto;
import com.ssd.blog.secureService.UserSecureService;

@RestController
@RequestMapping("/auth/api")
public class UserController {
	@Autowired
	private UserSecureService service;

//	@PreAuthorize("hasAnyRole('ADMIN','USER','MANAGER')")
//	@PostMapping("/users")
//	public ResponseEntity<?> saveUser(@RequestBody User user) {
//
//
//		List<Role> rolesList = new ArrayList<>();
//
//		Role role = new Role();
//		role.setRole("MANAGER");
//
//		rolesList.add(role);
//		user.setRoleslist(rolesList);
//		System.out.println(user);
//
//		return new ResponseEntity<User>(service.saveUser(user), HttpStatus.CREATED);
//
//	}

	@PostMapping(value = {"/register","/signup"})
	public ResponseEntity<?>registerUser(@RequestBody RegisterDto dto){
		
	String userdetails=	service.registerUser(dto);
	
		return new ResponseEntity<String>(userdetails, HttpStatus.CREATED);
		
	}
	
	@PostMapping(value = {"/login","/signin"})
	public ResponseEntity<?>logUser(@RequestBody LoginDto dto){
		
	String logUser=	service.userLogin(dto);
	
	return new ResponseEntity<String>(logUser, HttpStatus.OK);
		
	}


	 

}
