package com.java.seriesservice.exception;

import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.seriesservice.exception.message.SerieNotRegisteredException;
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

	@ExceptionHandler({SerieNotRegisteredException.class})
    public ResponseEntity<Object> handlerNotFound(Exception exception) {
      return new ResponseEntity<>(new DataError(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
