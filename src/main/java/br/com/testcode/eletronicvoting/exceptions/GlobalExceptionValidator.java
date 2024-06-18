package br.com.testcode.eletronicvoting.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionValidator {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionValidator(MethodArgumentNotValidException ex, WebRequest request) {
		List<String> errors = ex.getAllErrors().stream()
				.map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());

		ErrorSummary erroSummary = new ErrorSummary(errors, request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<>(erroSummary, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(IllegalCallerException.class)
	public ResponseEntity<?> globalExceptionIllegalArgument(IllegalCallerException ex, WebRequest request) {
		ErrorSummary erroSummary = new ErrorSummary(Collections.singletonList(ex.getMessage()), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<>(erroSummary, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> globalExceptionIllegalArgument(IllegalArgumentException ex, WebRequest request) {
		ErrorSummary erroSummary = new ErrorSummary(Collections.singletonList(ex.getMessage()), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<>(erroSummary, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityExistsException.class)
	public ResponseEntity<?> globalExceptionIllegalArgument(EntityExistsException ex, WebRequest request) {
		ErrorSummary erroSummary = new ErrorSummary(Collections.singletonList(ex.getMessage()), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<>(erroSummary, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> globalExceptionIllegalArgument(EntityNotFoundException ex, WebRequest request) {
		ErrorSummary erroSummary = new ErrorSummary(Collections.singletonList(ex.getMessage()), request.getDescription(false),
				LocalDateTime.now());

		return new ResponseEntity<>(erroSummary, HttpStatus.NOT_FOUND);
	}

}
