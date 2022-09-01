/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 1st September 2022
 ***********************************************************************/

package com.opengeography.exceptions;

public class NotValidNameException extends RuntimeException {

    public NotValidNameException(String entity, String name) {
        super(name + " is not a valid " + entity + " name !");
    }
}
