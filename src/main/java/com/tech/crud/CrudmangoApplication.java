package com.tech.crud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan()
public class CrudmangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudmangoApplication.class, args);
	}

}


