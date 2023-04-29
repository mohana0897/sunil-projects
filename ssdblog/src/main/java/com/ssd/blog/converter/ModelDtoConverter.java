 package com.ssd.blog.converter;

import org.springframework.stereotype.Component;

import com.ssd.blog.dto.PostDto;
import com.ssd.blog.model.Post;

@Component
public class ModelDtoConverter {

	public Post dtoToModel(PostDto dto) {

		Post post = new Post();
		post.setTitle(dto.getTitle());
		post.setDescription(dto.getDescription());
	//	post.setContent(dto.getContent());

		return post;

	}

	public PostDto ModelToDto(Post post) {

		PostDto dto = new PostDto();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDescription(post.getDescription());
		dto.setContent(post.getContent());

		return dto;
	}

}
