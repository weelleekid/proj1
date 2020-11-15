package com.project.sample.domain;

import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import java.time.LocalDateTime;
import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.project.sample.domain.posts.Posts;
import com.project.sample.domain.posts.PostsRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;
	
	@AfterEach
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void call() {

		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder().title("test").content("content").author("shineest96@gmail.com").build());

		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
		assertThat(posts.getTitle(),is("test"));
		assertThat(posts.getContent(),is("content"));
		assertThat(posts.getAuthor(),is("shineest96@gmail.com"));
	}
}
