package com.project.sample.service;

import java.util.*;
import java.util.stream.*;

import javax.transaction.Transactional;
import com.project.sample.dto.*;
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
	
	@Transactional
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
