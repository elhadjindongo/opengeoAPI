/***********************************************************************
 * Module:  CountryRepository.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Repository of Continent
 * Date: 8/29/2022
 * Project: openGeography
 ***********************************************************************/

package com.opengeography.repositories;

import com.opengeography.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
