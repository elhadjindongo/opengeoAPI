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
            @RequestParam(required = false) String phone,
            @RequestParam(required = false) String continent
    ) {
        List<Country> countries = new ArrayList<>();
        if (null != name) {
            countries.add(countryService.getOneByName(name));
            return countries;
        }
        if (null != code) {
            if (code.length() == s_TWO) {
                countries.add(countryService.getOneByCodeApha2(code));
                return countries;
            } else if (code.length() == s_THREE) {
                countries.add(countryService.getOneByCodeApha3(code));
                return countries;
            } else {
                throw new NotFoundException(s_COUNTRY, s_CODE, code);
            }
        }
        if (null != capital) {
            countries.add(countryService.getOneByCapitalCity(capital));
            return countries;
        }
        if (null != phone) {
            countries.add(countryService.getOneByPhone(phone));
            return countries;
        }
        if (null != continent) {
            return countryService.getAllByContinent(continent);
        }
        return countryService.getAll();
    }

    @GetMapping("/countries/{id}")
    public Country getOne(@PathVariable Long id) throws NotFoundException {
        return countryService.getOne(id);
    }

}
