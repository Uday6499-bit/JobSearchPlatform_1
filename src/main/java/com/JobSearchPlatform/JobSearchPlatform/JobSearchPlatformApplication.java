package com.JobSearchPlatform.JobSearchPlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.JobSearchPlatform.JobSearchPlatform")
 public class JobSearchPlatformApplication {

	public static void main(String[] args) {

		SpringApplication.run(JobSearchPlatformApplication.class, args);
		System.out.println("JobSearchPlatformApplication started");
	}

}
