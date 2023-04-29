package com.ssd.blog.config;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ssd.blog.jwtservice.AuthFilter;
import com.ssd.blog.secureService.UserService;

@Configuration
@EnableMethodSecurity
public class SpringConfig {
    
	User user=null;
	@Autowired
	private UserService service;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService detailsService;
	@Autowired
	private AuthFilter authFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

		
	return	httpSecurity.csrf()
		.disable()
		.authorizeHttpRequests()
						.requestMatchers("/auth/api/**").permitAll()
						.and()
						.authorizeHttpRequests()
						.requestMatchers(HttpMethod.GET,"/blog/api/**")
						.permitAll()
						.and()
						.authorizeHttpRequests()
					    .requestMatchers("/blog/api/**")
					    .hasAnyAuthority("ADMIN","USER")
					    .anyRequest()
						.authenticated()
						.and().sessionManagement()
						.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
						.and()
						.authenticationProvider(authenticationProvider())
						.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class)
						.build();
			
	
		 
	}
	

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity
//		.csrf()
//		.disable()
//		.authorizeHttpRequests()
//		.requestMatchers(HttpMethod.GET, "/blog/api/**")
//		.permitAll()
//		.requestMatchers(HttpMethod.POST, "/blog/api/**")
//		.hasRole("ADMIN").anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//		return httpSecurity.build();
//	}

//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.builder().username("sunil").password(passwordEncoder.encode("1234")).roles("ADMIN")
//				.build();
//		UserDetails user1 = User.builder().username("siva").password(passwordEncoder.encode("12345")).roles("USER")
//				.build();
//	List<com.ssd.blog.model.User> userList=	service.getAllUsers();
//		Collection<UserDetails> userDetailsServiceList=new ArrayList<>();
//	
//		for(com.ssd.blog.model.User users:userList) {
//		
//		UserDetails user2 = User  
//				.builder().
//				username(users.getUsername()).password(passwordEncoder.encode(users.getPassword())).roles("USER")
//				.build();
//		userDetailsServiceList.add((UserDetails) user2);
//		
//	}
//
//		return new InMemoryUserDetailsManager(userDetailsServiceList);
//
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
 
	
	
	  @Bean
	  public AuthenticationManager
	  authenticationManager(AuthenticationConfiguration
	  authenticationConfiguration) throws Exception {
	  
	  return authenticationConfiguration.getAuthenticationManager(); }
	 
	   @Bean
	    public AuthenticationProvider authenticationProvider(){
	        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
	        authenticationProvider.setUserDetailsService(detailsService);
	        authenticationProvider.setPasswordEncoder(passwordEncoder);
	        return authenticationProvider;
	    }
	
	
	
	
	
}
