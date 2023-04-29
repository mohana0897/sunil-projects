 package com.ssd.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssd.blog.exception.PostException;
import com.ssd.blog.model.Role;
import com.ssd.blog.model.User;
import com.ssd.blog.secureRepo.RoleRepository;
import com.ssd.blog.secureRepo.UserRepository;
@Service
public class BlogUserDetailsService  implements UserDetailsService {
    @Autowired
	private UserRepository repository;
    
    
    //@Autowired
   // private RoleRepository roleRepository;
	
	@Override
	public UserDetails loadUserByUsername(String emailOrUserName) throws UsernameNotFoundException {
		
	User user=	repository.findByUsername(emailOrUserName).orElseThrow(()->new UsernameNotFoundException("username is invalid"));
		System.out.println(user);
//	SimpleGrantedAuthority se= user.getRoleslist().stream().map(role-> new SimpleGrantedAuthority(role))
//     .collect(Collectors.toList());
List<GrantedAuthority> authorities=new ArrayList<>();


	
for(Role roles:user.getRoleslist()) {
	authorities.add(new SimpleGrantedAuthority(roles.getRole()));

}
     return new org.springframework.security.core.userdetails.User(
       user.getUsername(), user.getPassword(), authorities);
      
 }
}
