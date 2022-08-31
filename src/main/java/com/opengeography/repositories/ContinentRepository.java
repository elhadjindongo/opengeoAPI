/***********************************************************************
 * Module:  ContinentRepository.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Repository of Continent
 * Date: 29 August 2022
 * Project: openGeography
 ***********************************************************************/

package com.opengeography.repositories;

import com.opengeography.entities.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContinentRepository extends JpaRepository<Continent,Long> {
     Continent findOneByName(String name);
}
