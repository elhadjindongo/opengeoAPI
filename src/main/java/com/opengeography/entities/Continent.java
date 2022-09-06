/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Class Continent
 * Date: 29 August 2022
 ***********************************************************************/

package com.opengeography.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CONTINENT")
public class Continent {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100)
    private String name;
    @Column(length = 25)
    private String area;
    @Column(length = 10, name = "area_percent")
    private String areaPercent;
    @Column(length = 10)
    private String people; //population resident
    @Column(length = 10, name = "people_percent")
    private String peoplePercent; //pourcentage par rapport a la population mondiale
    private double density; // densite de la population au km2
    @Column(name = "total_countries")
    private int totalCountries;


    public Continent(String name, String area, String areaPercent, String people, String peoplePercent, double density, int totalCountries) {
        this.name = name;
        this.area = area;
        this.areaPercent = areaPercent;
        this.people = people;
        this.peoplePercent = peoplePercent;
        this.density = density;
        this.totalCountries = totalCountries;
    }
}