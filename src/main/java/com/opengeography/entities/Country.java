/***********************************************************************
 * Module:  Country.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Class Country
 * Date: 29 August 2022
 ***********************************************************************/

package com.opengeography.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
@Entity
@Table(name = "COUNTRY")
public class Country {
   @Id @GeneratedValue
   private Long id;
   @Column(length = 100)
   private String name;
   @Column(name = "full_name")
   private String fullName; // nom du pays version longue  | country's name in long  version
   @Column(name = "code_alpha2",length = 2)
   private String codeAlpha2;
   @Column(name = "code_alpha3",length = 3)
   private String codeAlpha3;
   @Column(length = 8)
   private String phone; // indicatif telephonique | Phone prefix
   @Column(name = "capital_city",length = 100)
   private String capitalCity;

   @ManyToOne
   public Continent continent;

   public Country(String name, String fullName, String codeAlpha2, String codeAlpha3, String phone, String capitalCity, Continent continent) {
      this.name = name;
      this.fullName = fullName;
      this.codeAlpha2 = codeAlpha2;
      this.codeAlpha3 = codeAlpha3;
      this.phone = phone;
      this.capitalCity = capitalCity;
      this.continent = continent;
   }
}