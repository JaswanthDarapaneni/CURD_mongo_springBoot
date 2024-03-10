package com.tech.crud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class CustomErrorController implements ErrorController {

	private static final String PATH = "/error";

	@RequestMapping(PATH)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Map<String, String> handleError() {
		Map<String, String> errorResponse = new HashMap<>();
		errorResponse.put("error", "Pleace check Api URL");
		return errorResponse;
	}

}
