/***********************************************************************
 * Module:  ContinentController.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Controller for Continent
 * Date: 29 August 2022
 ***********************************************************************/

package com.opengeography.controllers;


import com.opengeography.entities.Continent;
import com.opengeography.services.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ContinentController {
    @Autowired
    private ContinentService continentService;


    @GetMapping("/continents")
    public List<Continent> getAll(@RequestParam(required = false) String name) {
        List<Continent> continent = new ArrayList<>();
        if (null == name) {
            continent = continentService.getAll();
        } else {
            continent.add(continentService.getOneByName(name));
        }
        return continent;
    }

    @GetMapping("/continents/{id}")
    public Continent getOne(@PathVariable Long id) {
        return continentService.getOne(id);
    }

//    @GetMapping("/continents/{name}")
//    public Continent getOneByName(@PathVariable String name) {
//        return continentService.getOneByName(name);
//    }

}
