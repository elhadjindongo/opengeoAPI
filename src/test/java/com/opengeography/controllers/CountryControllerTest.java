/* Created by El Hadji M. NDONGO  */
/* on 01 09 2022 */
/* Project: openGeography */

package com.opengeography.controllers;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetCountry() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries"))
                .andExpect(status().isOk());
        //Country's name with first letter in capital
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=Senegal"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //Country's name in lower case
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=senegal"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //Country's name in Caps
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=SENEGAL"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
    }

    @Test
    public void testGetCountryByNameError() throws Exception {
        //Country's name contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=$@</>"))
                .andExpect(status().is4xxClientError());
        //Country's name contains digit
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=Senegal12"))
                .andExpect(status().is4xxClientError());
        //Country's name is digit
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=123"))
                .andExpect(status().is4xxClientError());
        //Country's name doesn't exist
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?name=test"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetCountryByCode() throws Exception {
        //Country's code all in caps alpha3
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=USA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code all in caps alpha2
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=US"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code all in lower case Aplha3
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=usa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code all in lower case Aplha2
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=us"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code all in caps alpah3
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=Usa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code some letter caps alpha3
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=USa"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
        //Country's code first letter in caps alpha2
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=Us"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Etat Unis")));
    }

    @Test
    public void testGetCountryByCodeError() throws Exception {
        //Country's code alpha3 contains digits
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=us1"))
                .andExpect(status().is4xxClientError());
        //Country's code alpha3 contains only digits
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=123"))
                .andExpect(status().is4xxClientError());

        //Country's code alpha3 contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=u$</b>"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetCountryByCapital() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?capital=Berlin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Allemagne")));
        //lower case
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?capital=berlin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Allemagne")));
        //all in caps
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?capital=BERLIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Allemagne")));
    }

    @Test
    public void testGetCountryByCapitalError() throws Exception {
        //Country's capital contains digits
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?capital=berlin1"))
                .andExpect(status().is4xxClientError());
        //Country's capital contains only digits
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=123"))
                .andExpect(status().is4xxClientError());

        //Country's capital contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?code=u$</b>"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetCountryByPhone() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=221"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //allin caps
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=+221"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //lower case
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=00221"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
    }

    @Test
    public void testGetCountryByPhoneError() throws Exception {
        //Country's phone contains letter
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=b123"))
                .andExpect(status().is4xxClientError());
        //Country's phone contains only letter
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=test"))
                .andExpect(status().is4xxClientError());

        //Country's phone contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?phone=u$</b>"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void testGetCountryByContinent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=Afrique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //allin caps
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=AFRIQUE"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
        //lower case
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=afrique"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", Matchers.is("Senegal")));
    }

    @Test
    public void testGetCountryByContinentError() throws Exception {
        //contains letter
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=b123"))
                .andExpect(status().is4xxClientError());
        //contains only letter
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=124"))
                .andExpect(status().is4xxClientError());

        //contains special char
        mockMvc.perform(MockMvcRequestBuilders.get("/countries?continent=u$</b>"))
                .andExpect(status().is4xxClientError());
    }
}
