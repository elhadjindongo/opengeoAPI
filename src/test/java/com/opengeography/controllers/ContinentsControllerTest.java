/* Created by El Hadji M. NDONGO  */
/* on 01 09 2022 */
/* Project: openGeography */

package com.opengeography.controllers;

import com.opengeography.services.ContinentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = ContinentController.class)
public class ContinentsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContinentService continentService;

    @Test
    public void testGetEmployees() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk());
    }
}
