/***********************************************************************
 * Module:  ContinentController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Continent
 ***********************************************************************/

package com.opengeography.controllers;


import com.opengeography.entities.Continent;
import com.opengeography.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
public class ContinentController {
    @Autowired
    private ContinentService continentService;


    @GetMapping("/continents")
    public List<Continent> getAll() {
        return continentService.getAll();
    }

    @GetMapping("/continents/{id}")
    public Optional<Continent> getOne(@PathVariable Long id) {
        return  continentService.getOne(id);
    }
}
