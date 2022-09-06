/***********************************************************************
 * Module:  DBInit.java
 * Author:  El Hadji M. NDONGO
 * Purpose: prepopulate the database
 * Date: 29 August 2022
 ***********************************************************************/
package com.opengeography.config;

import com.opengeography.entities.Continent;
import com.opengeography.entities.Country;
import com.opengeography.repositories.ContinentRepository;
import com.opengeography.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class DBInitDev {
    private static final Logger log = LoggerFactory.getLogger(DBInitDev.class);


    //@Bean
    CommandLineRunner loadDev(ContinentRepository continentRepository, CountryRepository countryRepository) {
        return args -> {
            log.info("Preloading Continents :");
            Continent asie = continentRepository.save(new Continent("Asie",	"44579000 km2",	"30 %",	"4436224000",	"60,2 %",99.51,	47));
            Continent afrique = continentRepository.save(new Continent("Afrique",	"30065000 km2"	,"20 %"	,"1216130000"	,"16,5 %"	,40.45	,54));
            Continent amerique = continentRepository.save(new Continent("Amérique du Sud",	"17819000 km2"	,"12 %"	,"410013492"	,"5,6 %"	,22.93	,12));
            Continent europe = continentRepository.save(new Continent("Europe"	,"9938000 km2",	"7 %"	,"738849000"	,"10,0 %",	74.35	,45));


            log.info("Preloading Countries :");
            Country country1 = countryRepository.save(new Country("+221", "SEN", "SN", "Sénégal", "Dakar", afrique, "République du Sénégal (PRm)", "196 722 km2"));
            Country country2 = countryRepository.save(new Country("+33", "FRA", "FR", "France", "Paris", europe, "République française", "551 695 km2"));
            Country country3 = countryRepository.save(new Country("+1", "USA", "US", "Etats-Unis", "Washington", amerique, "États-Unis d'amerique", "9 629 091 km2"));
            Country country4 = countryRepository.save(new Country("+86", "CHN", "CN", "Chine", "Pékin", asie, "République populaire de Chine", "9 600 000 km2"));
            Country country11 = countryRepository.save(new Country("+252", "SOM", "SO", "Somalie", "Mogadiscio", afrique, "République fédérale de Somalie", "637 657 km2"));
            Country country22 = countryRepository.save(new Country("+49", "DEU", "DE", "Allemagne", "Berlin", europe, "République fédérale d'Allemagne", "357 021 km2"));
            Country country33 = countryRepository.save(new Country("+57", "COL", "CO", "Colombie", "Bogota", amerique, "République de Colombie (PRm)", "1 141 748 km2"));

            Country country44 = countryRepository.save(new Country("+91", "IND", "IN", "Inde", "New Delhi", asie, "République de l'Inde", "3 287 263 km2"));

            log.info(country1.toString());
            log.info(country2.toString());
            log.info(country3.toString());
            log.info(country4.toString());
            log.info(country11.toString());
            log.info(country22.toString());
            log.info(country33.toString());
            log.info(country44.toString());
        };
    }

}
