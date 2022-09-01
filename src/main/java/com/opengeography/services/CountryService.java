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

import static com.opengeography.utils.Utils.*;

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
        name = validateName(name, s_COUNTRY);
        Country country = countryRepository.findOneByName(name);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY,s_NAME, name);
        }
        return country;
    }

    public Country getOneByCodeApha2(String code) {
        if (code.length() != s_TWO || !isWord(code)) {
            throw new NotFoundException(s_COUNTRY, s_CODE, code);
        }
        code = code.toUpperCase();
        Country country = countryRepository.findOneByCodeAlpha2(code);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY, s_CODE, code);
        }
        return country;
    }

    public Country getOneByCodeApha3(String code) {
        if (code.length() != s_THREE || !isWord(code)) {
            throw new NotFoundException(s_COUNTRY, s_CODE, code);
        }
        code = code.toUpperCase();
        Country country = countryRepository.findOneByCodeAlpha3(code);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY, s_CODE, code);
        }
        return country;
    }

    public Country getOneByPhone(String phone) {
        //TODO
        return null;
    }

    public Country getOneByCapitalCity(String city) {
        city = validateName(city, s_CITY);
        Country country = countryRepository.findOneByCapitalCityContains(city);
        if (null == country) {
            throw new NotFoundException(s_COUNTRY,s_CITY, city);
        }
        return country;
    }

}
