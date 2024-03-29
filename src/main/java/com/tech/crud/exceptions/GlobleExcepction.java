package com.tech.crud.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tech.crud.exceptions.customExcepctions.ResourceNotFoundException;


@RestControllerAdvice
public class GlobleExcepction {
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> catchNullPointerException(NullPointerException e){
		Map<String, String> responce = new HashMap<>();
		System.out.println(e.getMessage());
		responce.put("error Msg", e.getMessage());
		return responce;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, String> MethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> res =  new HashMap<>();
	    e.getBindingResult().getAllErrors().forEach(t ->{
	    	String fieldName = ((FieldError) t).getField() ;
	    	String errorMsg = t.getDefaultMessage();
	    	res.put(fieldName, errorMsg);
	    });
	    return res;
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.BAD_GATEWAY)
	public Map<String, String> catchResourceNotFoundException(ResourceNotFoundException e){
		Map<String, String> responce = new HashMap<>();
		responce.put("error Msg", e.getMessage());
		return responce;
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	public ResponseEntity< Map<String, String>> catchNoSuchElementException(NoSuchElementException e){
		Map<String, String> responce = new HashMap<>();
		System.out.println(e.getMessage());
		responce.put("error Msg", e.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(responce);
	}
	
	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public Map<String, String> catchNotFoundException(NotFoundException e){
		Map<String, String> responce = new HashMap<>();
		responce.put("NotFound Msg", e.getMessage());
		return responce;
	}

}
