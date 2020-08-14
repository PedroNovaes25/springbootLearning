/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste2boot.demospring2.resources.exceptions;

import com.teste2boot.demospring2.services.exceptions.ObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @author guita
 */

@ControllerAdvice
public class ResourceExceptionHandler {
    
    
    @ExceptionHandler(ObjectNotFoundException.class) // define que esse é um tratador de exceptions da classe entre parenteses
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request)
    {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
