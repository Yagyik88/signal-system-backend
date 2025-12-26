package com.signal_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
	    "controller",
	    "service",
	    "repository",
	    "model",
	    "dto",
	    "enums"
	})
@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "model")
public class SignalSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignalSystemApplication.class, args);
	}

}
