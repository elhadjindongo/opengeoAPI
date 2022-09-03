/* Created by El Hadji M. NDONGO  */
/* on 01 09 2022 */
/* Project: openGeography */

package com.opengeography.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ContinentController.class)
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryController countryController;

    @Test
    public void testGetCountry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk());
    }
}
