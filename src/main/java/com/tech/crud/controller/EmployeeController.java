package com.tech.crud.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tech.crud.dto.employeedto;
import com.tech.crud.service.EmployeService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeService empService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public String createEmployee(@Valid @RequestBody employeedto emp) {
//return "im calling";
		return empService.createEmployee(emp);
	}

	@GetMapping("/get")
	@ResponseStatus(HttpStatus.OK)
	public List<employeedto> getAllEmployes() {
		return empService.getAllEmpoyees();
	}

//	65ec263c78b624761d57886e
	@DeleteMapping("delete/{id}")
	public String removeEmployee( @PathVariable String id) throws NotFoundException, NullPointerException, NoSuchElementException {
		
			return empService.deleteEmployee(id);
	}

	@PutMapping("update")
	public String putMethodName(@RequestBody employeedto entity) {
		// TODO: process PUT request
		return empService.UpdateEmployee(entity);
	}

}
