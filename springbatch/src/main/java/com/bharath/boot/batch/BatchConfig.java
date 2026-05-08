package com.bharath.boot.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration

public class BatchConfig {

	@Autowired
	private JobRepository jobRepository;	

	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	Job job() {
		return new JobBuilder("job-1", jobRepository).start(step()).listener(listener()).build();
	}

	@Bean
	Step step() {
		StepBuilder stepBuilder = new StepBuilder("step-1", jobRepository);
		return stepBuilder.<String, String>chunk(2, transactionManager).reader(reader()).processor(processor())
				.writer(writer()).build();
	}

	@Bean
	Reader reader() {
		return new Reader();
	}

	@Bean
	Writer writer() {
		return new Writer();
	}

	@Bean
	Processor processor() {
		return new Processor();
	}

	@Bean
	MyJobListener listener() {
		return new MyJobListener();
	}

}