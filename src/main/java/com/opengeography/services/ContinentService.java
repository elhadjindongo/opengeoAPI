/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Service Continent
 * Date: 29 August 2022
 ***********************************************************************/
package com.opengeography.services;

import com.opengeography.entities.Continent;
import com.opengeography.exceptions.NotFoundException;
import com.opengeography.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepository continentRepository;


    public List<Continent> getAll() {
        return continentRepository.findAll();
    }


    public Continent getOne(@PathVariable Long id) {
        return continentRepository.findById(id).orElseThrow(() -> new NotFoundException("Continent", id));
    }
}
