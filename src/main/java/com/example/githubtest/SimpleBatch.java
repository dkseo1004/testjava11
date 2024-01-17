package com.example.githubtest;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableBatchProcessing
@Slf4j // log 사용을 위한 lombok 어노테이션
@RequiredArgsConstructor
public class SimpleBatch {
	@Bean
	public Job testSimpleJob(JobRepository jobRepository, Step testStep){
		return new JobBuilder("testSimpleJob", jobRepository)
			.start(testStep)
			.build();

	}

	@Bean
	public Step testStep(JobRepository jobRepository, Tasklet testTasklet, PlatformTransactionManager platformTransactionManager){
		return new StepBuilder("testStep", jobRepository)
			.tasklet(testTasklet, platformTransactionManager).build();
	}

	@Bean
	public Tasklet testTasklet(){
		return ((contribution, chunkContext) -> {
			System.out.println("테스트1");

			return RepeatStatus.FINISHED;
		});
	}

}
