package com.tech.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tech.crud.dto.employeedto;
import com.tech.crud.service.EmployeService;

@SpringBootApplication
@ComponentScan()
public class CrudmangoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudmangoApplication.class, args);
	}

}


