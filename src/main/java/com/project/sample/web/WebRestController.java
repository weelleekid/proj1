package com.project.sample.web;
import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.sample.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {
	
	private PostsService postsService;
	private Environment env;
	
	@GetMapping(value = "/hello")
	public String hello() {
		return "hello";
	}
	
	@PostMapping("/posts") // object Object  -> return value => void -> Boolean
	public Boolean savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsService.save(dto);
		return true;
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		return Arrays.stream(env.getActiveProfiles())
				.findFirst()
				.orElse("");
	}
}
