package com.java.moviesservice.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.moviesservice.exception.message.MovieNotRegisteredException;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

@ControllerAdvice
public class GlobalExceptions {
	@ExceptionHandler({
      NullPointerException.class,
      PropertyValueException.class,
      HttpMessageNotReadableException.class,
      MysqlDataTruncation.class
	})
    public ResponseEntity<Object> handlerBadRequest(Exception exception) {
      return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler({MovieNotRegisteredException.class})
    public ResponseEntity<Object> handlerNotFound(Exception exception) {
      return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
