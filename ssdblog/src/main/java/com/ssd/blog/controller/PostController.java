package com.ssd.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssd.blog.dto.PostDto;
import com.ssd.blog.model.Post;
import com.ssd.blog.service.PostService;
import com.ssd.blog.service.ResponseValidateService;

@RestController
@RequestMapping("/blog/api")
public class PostController {
	

	@Autowired
	private PostService postService;
	@Autowired
	private ResponseValidateService service;

	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	@PostMapping("/posts")
	public ResponseEntity<?> uploadPost(@Validated @RequestBody PostDto dto, BindingResult bindingResult) {

		
		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {
			return new ResponseEntity<Post>(postService.uploPost(dto), HttpStatus.CREATED);
		}

	}

	// @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/posts")
	public ResponseEntity<?> getAllPosts(
			@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "1", required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = "desc", required = false) String sortDir) {

		return new ResponseEntity<List<PostDto>>(postService.getAllPosts(pageNo, pageSize, sortBy, sortDir),
				HttpStatus.OK);
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<?> getPostById(@PathVariable("id") Long id) {

		return new ResponseEntity<PostDto>(postService.getPostByID(id), HttpStatus.OK);

	}

	@PreAuthorize("hasAnyAuthority('ADMIN','USER')")
	@PutMapping("posts/{id}")
	public ResponseEntity<?> updatepost(@PathVariable Long id, @Validated @RequestBody PostDto dto,
			BindingResult bindingResult) {

		if (service.validateData(bindingResult) != null) {
			return service.validateData(bindingResult);

		} else {

			return new ResponseEntity<PostDto>(postService.updatePost(dto, id), HttpStatus.OK);
		}
	}

	@DeleteMapping("posts/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable("id") Long id) {
		postService.deletePostById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
