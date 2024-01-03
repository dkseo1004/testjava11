package com.example.githubtest.member;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@RedisHash("user")
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	@Id
	private String id;

	private String name;
	private int age;
}
