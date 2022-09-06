/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Service Continent
 * Date: 29 August 2022
 ***********************************************************************/
package com.opengeography.services;

import com.opengeography.config.DBInitDev;
import com.opengeography.entities.Continent;
import com.opengeography.exceptions.NotFoundException;
import com.opengeography.repositories.ContinentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static com.opengeography.utils.Utils.*;

@Service
public class ContinentService {
    private static final Logger log = LoggerFactory.getLogger(DBInitDev.class);

    @Autowired
    private ContinentRepository continentRepository;

    /**
     * @return the list of all continents in the DB
     */
    public List<Continent> getAll() {
        return continentRepository.findAll();
    }

    /**
     * @param id an integer that can be an id of a continent
     * @return the continent that is identified by the given ID
     */
    public Continent getOne(@PathVariable Long id) {
        return continentRepository.findById(id).orElseThrow(() -> new NotFoundException(s_CONTINENT, id));
    }

    /**
     * @param name a string that can be a name of a continent
     * @return a continent that has the exact name given in param
     */
    public Continent getOneByName(String name) {
        name = validateName(name,s_CONTINENT);
        Continent continent = continentRepository.findOneByName(name);
        if (null == continent) {
            throw new NotFoundException(s_CONTINENT,s_NAME, name);
        }
        return continent;
    }

}
