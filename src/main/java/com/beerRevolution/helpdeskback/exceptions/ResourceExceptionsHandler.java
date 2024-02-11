package com.beerRevolution.helpdeskback.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

////CLASSE ->  MANIPULADORA DE EXCEPTIONS
@ControllerAdvice
public class ResourceExceptionsHandler {

    //retorno de responseEntity do objeto StandardError

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex,
                                                                 HttpServletRequest httpRequest){

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),"OBJECT NOT FOUND ,se fudeu game over!", ex.getMessage(), httpRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);


    }

}
