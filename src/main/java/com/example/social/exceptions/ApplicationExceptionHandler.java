package com.example.social.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler{

    @ExceptionHandler(value = UsernameAlreadyPresentException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyPresentException(UsernameAlreadyPresentException exception){
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("error", exception.getMessage());
        return new ResponseEntity(responseMap,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = UserDoesNotExistsException.class)
    public ResponseEntity<Map<String,String>> handleUserDoesNotExistsException(UserDoesNotExistsException existsException){
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("error", existsException.getMessage());
        return new ResponseEntity(responseMap,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
