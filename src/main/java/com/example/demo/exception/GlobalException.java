package com.example.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handlesAllExceptions(Exception ex) {
		Map<String, Object> exceptionErrors = new HashMap<String, Object>();
		exceptionErrors.put("message", ex.getMessage());
		exceptionErrors.put("Status", "failed");

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionErrors);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleAllExceptionErrors(MethodArgumentNotValidException ex) {
		Map<String, String> errorsMap = new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(errors -> {
			errorsMap.put(errors.getField(), errors.getDefaultMessage());
		});
		System.out.println(errorsMap);
		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("message", "unable to process your request");
		responseMap.put("status", "Failed");
		responseMap.put("errors", errorsMap);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
	}
}
