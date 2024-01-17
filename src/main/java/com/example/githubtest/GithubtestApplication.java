package com.example.githubtest;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing

public class GithubtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GithubtestApplication.class, args);
	}

}
