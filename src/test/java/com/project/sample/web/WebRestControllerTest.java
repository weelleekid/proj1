package com.project.sample.web;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebRestControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void profile() {
		String profile = this.restTemplate.getForObject("/profile", String.class);
		assertThat(profile).isEqualTo("local");
	}
}
