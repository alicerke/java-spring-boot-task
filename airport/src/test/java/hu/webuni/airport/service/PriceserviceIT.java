package hu.webuni.airport.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles({"prod", "test"})
public class PriceserviceIT {
	
	@Autowired
	PriceService priceService;

	@Test
	void testDetFinalPrice2() throws Exception {
				
		int newPrice = priceService.getFinalPrice(100);
		assertThat(newPrice).isEqualTo(90);
	}	
	
	@Test
	void testDetFinalPriceWithHighPrice() throws Exception {
		
		int newPrice = priceService.getFinalPrice(11000);
		assertThat(newPrice).isEqualTo(9350);
	}	
}
