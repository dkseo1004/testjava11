package com.example.githubtest;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ProfileController {

	private final Environment env;

	@GetMapping("/profile")
	public String getProfile() {
		List<String> profile = Arrays.asList(env.getActiveProfiles());
		List<String> realProfiles = Arrays.asList("set1", "set2");
		String defaultProfile = profile.isEmpty() ? "default" : profile.get(0);

		return profile.stream()
			.filter(realProfiles::contains)
			.findAny()
			.orElse(defaultProfile);
	}

}
