/***********************************************************************
 * Module:  CountryRepository.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Repository of Continent
 * Date: 29 August 2022
 * Project: openGeography
 ***********************************************************************/

package com.opengeography.repositories;

import com.opengeography.entities.Continent;
import com.opengeography.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findOneByName(String name);

    Country findOneByCodeAlpha2(String codeAlpha2);

    Country findOneByCodeAlpha3(String codeAlpha3);

    Country findOneByPhone(String phonePrefix);

    Country findOneByCapitalCityContains(String city);

    List<Country> findAllByContinent(Continent continent);
}
