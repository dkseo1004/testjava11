package com.example.githubtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping("/")
	public String test(){
			return "확인주입니다@@!";
	}

}
