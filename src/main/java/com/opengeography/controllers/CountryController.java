/***********************************************************************
 * Module:  CountryController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Country
 ***********************************************************************/
package com.opengeography.controllers;

import com.opengeography.entities.Country;
import com.opengeography.exceptions.NotFoundException;
import com.opengeography.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.opengeography.utils.Utils.s_COUNTRY;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code
    ) {
        if (null != name) {
            List<Country> country = new ArrayList<>();
            country.add(countryService.getOneByName(name));
            return country;
        }
        if (null != code) {
            List<Country> country = new ArrayList<>();
            if (code.length() == 2) {
                country.add(countryService.getOneByCodeApha2(code));
                return country;
            } else if (code.length() == 3) {
                country.add(countryService.getOneByCodeApha3(code));
                return country;
            } else {
                throw new NotFoundException(s_COUNTRY, code);
            }
        }
        return countryService.getAll();
    }

    @GetMapping("/countries/{id}")
    public Country getOne(@PathVariable Long id) throws NotFoundException {
        return countryService.getOne(id);
    }

}
