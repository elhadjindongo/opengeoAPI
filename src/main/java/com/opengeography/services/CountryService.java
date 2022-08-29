/***********************************************************************
 * Module:  CountryService.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Service Continent
 ***********************************************************************/
package com.opengeography.services;

import com.opengeography.entities.Continent;
import com.opengeography.entities.Country;
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


    public Optional<Country> getOne(Long id) {
        return countryRepository.findById(id);
    }
}
