/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Service Continent
 ***********************************************************************/
package com.opengeography.services;

import com.opengeography.entities.Continent;
import com.opengeography.repositories.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Service
public class ContinentService {
    @Autowired
    private ContinentRepository continentRepository;


    public List<Continent> getAll() {
        return continentRepository.findAll();
    }


    public Optional<Continent> getOne(@PathVariable Long id) {
        return continentRepository.findById(id);
    }
}
