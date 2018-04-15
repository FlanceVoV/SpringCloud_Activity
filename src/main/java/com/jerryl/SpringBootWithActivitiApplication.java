package com.jerryl;

import org.activiti.user_group.CustomGroupEntityManagerFactory;
import org.activiti.user_group.CustomUserEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.jerryl","org.activiti"})
public class SpringBootWithActivitiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithActivitiApplication.class, args);
	}



	@Bean
	public CustomGroupEntityManagerFactory getCustomGroupEntityManagerFactory(){
		return new CustomGroupEntityManagerFactory();
	}

	@Bean
	public CustomUserEntityManagerFactory getCustomUserEntityManagerFactory(){
		return new CustomUserEntityManagerFactory();
	}


}
