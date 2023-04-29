package com.ssd.blog.secureRepo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssd.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByRole(String role);
	
	
	
}
