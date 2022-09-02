/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 2nd September 2022
 ***********************************************************************/

package com.opengeography.exceptions;

public class NotValidPhonePrefixException extends RuntimeException {

    public NotValidPhonePrefixException(String phonePrefix) {
        super(phonePrefix + " is not a valid phone prefix!");
    }
}
