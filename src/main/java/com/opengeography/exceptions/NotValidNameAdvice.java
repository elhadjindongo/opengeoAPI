/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Exception advice for NotFoundException
 * Date: 1st September 2022
 ***********************************************************************/

package com.opengeography.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotValidNameAdvice {
    @ResponseBody
    @ExceptionHandler(NotValidNameException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String notValidNameHandler(NotValidNameException ex) {
        return ex.getMessage();
    }
}
