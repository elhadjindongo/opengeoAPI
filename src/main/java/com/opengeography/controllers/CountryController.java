/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 ***********************************************************************/
package com.opengeography.controllers;

import com.opengeography.entities.Continent;
import com.opengeography.entities.Country;
import com.opengeography.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAll() {
        return countryService.getAll();
    }

    @GetMapping("/countries/{id}")
    public Optional<Country> getOne(@PathVariable Long id) {
        return  countryService.getOne(id);
    }

}
