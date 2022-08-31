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
import com.opengeography.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.opengeography.utils.Utils.s_COUNTRY;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;


    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    public Country getOne(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new NotFoundException(s_COUNTRY, id));
    }

    public Country getOneByName(String name) {
        if (name.isEmpty()) {
            throw new NotFoundException(s_COUNTRY, name);
        }
        name = Utils.toCamelCase(name);
        Country country = countryRepository.findOneByName(name);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY, name);
        }
        return country;
    }

    public Country getOneByCodeApha2(String code) {
        if (code.length() != 2) {
            throw new NotFoundException(s_COUNTRY, code);
        }
        code = code.toUpperCase();
        Country country = countryRepository.findOneByCodeAlpha2(code);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY, code);
        }
        return country;
    }

    public Country getOneByCodeApha3(String code) {
        if (code.length() != 3) {
            throw new NotFoundException(s_COUNTRY, code);
        }
        code = code.toUpperCase();
        Country country = countryRepository.findOneByCodeAlpha3(code);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY, code);
        }
        return country;
    }
}
