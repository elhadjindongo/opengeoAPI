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

import static com.opengeography.utils.Utils.*;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String capital,
            @RequestParam(required = false) String phone
    ) {
        if (null != name) {
            List<Country> country = new ArrayList<>();
            country.add(countryService.getOneByName(name));
            return country;
        }
        if (null != code) {
            List<Country> country = new ArrayList<>();
            if (code.length() == s_TWO) {
                country.add(countryService.getOneByCodeApha2(code));
                return country;
            } else if (code.length() == s_THREE) {
                country.add(countryService.getOneByCodeApha3(code));
                return country;
            } else {
                throw new NotFoundException(s_COUNTRY, s_CODE, code);
            }
        }
        if (null != capital) {
            List<Country> country = new ArrayList<>();
            country.add(countryService.getOneByCapitalCity(capital));
            return country;
        }
        if (null != phone) {
            List<Country> country = new ArrayList<>();
            country.add(countryService.getOneByPhone(phone));
            return country;
        }
        return countryService.getAll();
    }

    @GetMapping("/countries/{id}")
    public Country getOne(@PathVariable Long id) throws NotFoundException {
        return countryService.getOne(id);
    }

}
