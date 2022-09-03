package com.opengeography;

import com.opengeography.controllers.ContinentController;
import com.opengeography.controllers.CountryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OpenGeographyApplicationTests {

	@Autowired
	private ContinentController continentController;
	@Autowired
	private CountryController countryController;

	@Test
	void contextLoads() {
		assertThat(continentController).isNotNull();
		assertThat(countryController).isNotNull();
	}

}
