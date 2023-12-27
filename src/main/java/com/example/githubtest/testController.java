package com.example.githubtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping("/test")
	public String test(){
			return "ts1223212";
	}

	// @GetMapping("/")
	// public String index() {
	// 	return "index";
	// }@GetMapping("/home")
	// public String home() {
	// 	return "home";
	// }
}
