/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 31 August 2022
 ***********************************************************************/
package com.opengeography.utils;

public class Utils {

    public static final String s_CONTINENT = "Continent";
    public static final String s_COUNTRY = "Country";

    /**
     * Transform a word by making the first caracter uppercase and all of the rest in lowercase
     *
     * @param word
     * @return a string white a first character in capital
     */
    public static String toCamelCase(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.toLowerCase().substring(1);
    }
}
