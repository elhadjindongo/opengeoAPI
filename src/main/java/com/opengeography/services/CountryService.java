/***********************************************************************
 * Module:  CountryService.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Service Continent
 * Date: 29 August 2022
 ***********************************************************************/
package com.opengeography.services;

import com.opengeography.entities.Country;
import com.opengeography.exceptions.NotFoundException;
import com.opengeography.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;


    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getOne(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new NotFoundException("Country", id));
    }
}
