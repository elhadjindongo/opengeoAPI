/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 29 August 2022
 ***********************************************************************/

package com.opengeography.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String entity, Long id) {
        super(entity + " with id = " + id + " doesn't exist !");
    }

    public NotFoundException(String entity,String field, String name) {
        super(entity + " with the "+field+" " + name + " doesn't exist !");
    }
}
