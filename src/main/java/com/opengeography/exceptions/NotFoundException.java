/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 29 August 2022
 ***********************************************************************/

package com.opengeography.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String country, Long id) {
        super(country + " with id = " + id + " doesn't exist !");
    }
}
