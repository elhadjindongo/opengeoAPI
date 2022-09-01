/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 * Date: 31 August 2022
 ***********************************************************************/
package com.opengeography.utils;

import com.opengeography.exceptions.NotFoundException;
import com.opengeography.exceptions.NotValidNameException;

public class Utils {

    public static final String s_CONTINENT = "Continent";
    public static final String s_COUNTRY = "Country";
    public static final String s_NAME = "name";
    public static final String s_CODE = "code alpha";
    private static final String s_ONLY_LETTERS_REGEX = "[a-zA-Z]+";
    public static final int s_TWO = 2;
    public static final int s_THREE = 3;

    /**
     * Transform a word by making the first caracter uppercase and all of the rest in lowercase
     *
     * @param word
     * @return a string white a first character in capital
     */
    public static String toCamelCase(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.toLowerCase().substring(1);
    }


    /**
     * @param text
     * @return if the given text contains only alphabetical letters or not
     */
    public static Boolean isWord(String text) {
        return text.matches(s_ONLY_LETTERS_REGEX);
    }


    /**
     * Verify that name given in param is not empty, contains only alphabetical letters and return the name in camelcase
     *
     * @param name
     * @return the name given in param in camelcase after verifying it's not empty and contains only alphabetical letters
     */
    public static String validateName(String name, String entity) {
        if (name.isEmpty()) {
            throw new NotFoundException(entity, s_NAME, name);
        }
        if (!isWord(name)) {
            throw new NotValidNameException(entity, name);
        }
        return name = Utils.toCamelCase(name);
    }

}
