/***********************************************************************
 * Module:  DBInit.java
 * Author:  El Hadji M. NDONGO
 * Purpose: prepopulate the database
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


@Configuration
public class DBInit {
    private static final Logger log = LoggerFactory.getLogger(DBInit.class);


    @Bean
    CommandLineRunner load(ContinentRepository continentRepository, CountryRepository countryRepository) {
        return args -> {
            log.info("Preloading Continents :");
            Continent continent1 = continentRepository.save(new Continent("Afrique", "100 000 km2", 52));
            Continent continent2 = continentRepository.save(new Continent("Amerique", "10 000 000 km2", 68));
            Continent continent3 = continentRepository.save(new Continent("Asie", "52 00 000 km2", 105));
            Continent continent4 = continentRepository.save(new Continent("Europe", "12 300 km2", 83));

            log.info(continent1.toString());
            log.info(continent2.toString());
            log.info(continent3.toString());
            log.info(continent4.toString());

            log.info("Preloading Countries :");
            Country country1 = countryRepository.save(new Country("Senegal", "Republique du Senegal", "SN", "SEN", "+221", "Dakar", continent1));
            Country country2 = countryRepository.save(new Country("France", "Republique Francaise", "FR", "FRA", "+33", "Paris", continent4));
            Country country3 = countryRepository.save(new Country("Etat Unis", "Etat Unies d'Amerique", "US", "USA", "+1", "Washington", continent2));
            Country country4 = countryRepository.save(new Country("Chine", "Republique Populaire de Chine", "CH", "CHN", "+86", "Pekin", continent3));
            Country country11 = countryRepository.save(new Country("Somalie", "République fédérale de Somalie", "SO", "SOM", "+252", "Mogadiscio", continent1));
            Country country22 = countryRepository.save(new Country("Allemagne", "République fédérale d'Allemagne", "DE", "DEU", "+49", "Berlin", continent4));
            Country country33 = countryRepository.save(new Country("Colombie", "République de Colombie", "CO", "COL", "+57", "Bogota", continent2));
            Country country44 = countryRepository.save(new Country("Inde", "République de l'Inde", "IN", "IND", "+91", "New Delhi", continent3));

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
