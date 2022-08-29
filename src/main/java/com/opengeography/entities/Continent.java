/***********************************************************************
 * Module:  Continent.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Class Continent
 ***********************************************************************/

package com.opengeography.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data @ToString @NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "CONTINENT")
public class Continent {
   @Id @GeneratedValue
   private Long id;
   @Column(length = 100)
   private String name;
   @Column(length = 25)
   private String area;
   @Column(name = "total_countries")
   private int totalCountries;


   public Continent(String name, String area, int totalCountries) {
      this.name = name;
      this.area = area;
      this.totalCountries = totalCountries;
   }
}