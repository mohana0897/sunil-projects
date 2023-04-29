package com.ssd.blog.secureService;

import com.ssd.blog.model.User;
import com.ssd.blog.secureRepo.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder encoader;
	
	
	
	
	




	public User saveUser(User user) {
	user.setPassword(encoader.encode(user.getPassword()));
	User user2=	repository.save(user);
		
		return user2;
		
	}
	
	
//	
//	
//	
//
////	public User getUser(String email, String username) {
////		User user= repository.getUser(email, username);
////		if(user.getEmail()==null&&user
////				.getUsername()!=null||user
////				.getEmail()!=null&&user.getUsername()==null) {
////			return user;
////		}else {
////			throw new PostException("please enter valid username or email");
////		}
////		
////	}
//
//	public User getUserByEmail(String email) {
//		User user = repository.findByEmail(email);
//
//		if (user.getEmail() != null) {
//			return user;
//		} else {
//			throw new PostException("please enter valid email");
//
//		}
//
//	}
//	public User getUserByUsername(String username) {
//		User user = repository.findByUsername(username);
//
//		if (user.getUsername()!= null) {
//			return user;
//		} else {
//			throw new PostException("please enter valid UserName");
//
//		}
//
//	}
//	
//	
//	
//
//	public List<User> getAllUsers() {
//
//		return repository.findAll();
//	}

}
