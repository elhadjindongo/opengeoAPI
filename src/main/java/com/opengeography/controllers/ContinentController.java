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
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<Continent> getOne(@PathVariable Long id) {
        Continent continent = continentService.getOne(id);
        return EntityModel.of(continent, //
                linkTo(methodOn(ContinentController.class).getOne(id)).withSelfRel(),
                linkTo(methodOn(ContinentController.class).getAll(continent.getName())).withSelfRel());
    }

//    @GetMapping("/continents/{name}")
//    public Continent getOneByName(@PathVariable String name) {
//        return continentService.getOneByName(name);
//    }

}
