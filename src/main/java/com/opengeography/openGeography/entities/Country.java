/***********************************************************************
 * Module:  Country.java
 * Author:  El Hadji M. NDONGO
 * Purpose: Defines the Class Country
 ***********************************************************************/

package com.opengeography.openGeography.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "COUNTRY")
public class Country {
   @Id
   private Long id;
   @Column(length = 100)
   private String name;
   @Column(name = "full_name")
   private String fullName; // nom du pays version longue  / country's name in long  version
   @Column(name = "code_alpha2",length = 2)
   private String codeAlpha2;
   @Column(name = "code_alpha3",length = 3)
   private String codeAlpha3;
   @Column(length = 8)
   private String phone; // indicatif telephonique / Phone prefix
   @Column(name = "capital_city",length = 100)
   private String capitalCity;

   @ManyToOne
   public Continent continent;

}