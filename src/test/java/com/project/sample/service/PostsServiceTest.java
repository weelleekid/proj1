package com.project.sample.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.sample.domain.posts.Posts;
import com.project.sample.domain.posts.PostsRepository;
import com.project.sample.web.PostsSaveRequestDto;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsServiceTest {
	
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@AfterEach
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void save() {
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("test")
				.content("test")
				.author("shineest96@gmail.com")
				.build();
		
		postsService.save(dto);
		
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
	}
	
}
