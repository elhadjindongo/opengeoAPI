/* Created by El Hadji M. NDONGO  */
/* on 01 09 2022 */
/* Project: openGeography */

package com.opengeography.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ContinentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetContinent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/continents"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].name", Matchers.is("Afrique")));
    }

    @Test
    public void testGetContinentByNameLower() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name=europe"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].name", Matchers.is("Europe")));
    }

    @Test
    public void testGetContinentByNameCapital() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name=Asie"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].name", Matchers.is("Asie")));
    }

    @Test
    public void testGetContinentByNameError() throws Exception {
        //Continent's name contains digits
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name=Asie23"))
                .andExpect(status().is4xxClientError());
        //Continent's name is empty
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name="))
                .andExpect(status().is4xxClientError());
        //Continent's name contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name=c-$<>"))
                .andExpect(status().is4xxClientError());
        //Continent doesn't exist
        mockMvc.perform(MockMvcRequestBuilders.get("/continents?name=test"))
                .andExpect(status().is4xxClientError());
    }

}
