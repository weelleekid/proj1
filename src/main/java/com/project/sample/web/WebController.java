package com.project.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	
	//새로운 의존성 추가 시 프로젝트 갱신
	@GetMapping(value = "/")
	public String main() {
		return "main";
	}
}
