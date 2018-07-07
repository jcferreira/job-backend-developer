package br.com.intelipost.startapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.intelipost.controller"})
@EntityScan("br.com.intelipost.integration.domain")
@EnableJpaRepositories("br.com.intelipost.integration.repository")
public class StartApplication {
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
}
