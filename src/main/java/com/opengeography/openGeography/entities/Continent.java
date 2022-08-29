/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Class Continent
 ***********************************************************************/

package com.opengeography.openGeography.entities ;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data @Inheritance @Table(name = "CONTINENT")
public class Continent {
   @Id
   private Long id;
   @Column(length = 100)
   private String name;
   private float area;
   @Column(name = "total_countries")
   private int totalCountries;

   @OneToMany(mappedBy = "continent",orphanRemoval = true)
   public Collection<Country> country;
 

}