package com.project.sample.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.sample.domain.posts.PostsRepository;
import com.project.sample.web.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
}
