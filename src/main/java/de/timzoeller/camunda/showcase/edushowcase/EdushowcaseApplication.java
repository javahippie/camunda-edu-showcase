package de.timzoeller.camunda.showcase.edushowcase;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableProcessApplication
public class EdushowcaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdushowcaseApplication.class, args);
	}

}
