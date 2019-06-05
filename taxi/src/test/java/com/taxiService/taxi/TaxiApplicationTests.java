package com.taxiService.taxi;

import com.taxiService.taxi.models.PriceFactory;
import com.taxiService.taxi.models.TaxiCar;
import com.taxiService.taxi.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TaxiApplicationTests {

	@Test
	public void priceTest() {
		TaxiCar taxiCar = new TaxiCar();
		taxiCar.setRequestTime(LocalTime.now());
		taxiCar.setTarif();
		Assertions.assertEquals(PriceFactory.getPrice(LocalTime.now()).price(),taxiCar.getTarif());
	}

	@Test
	public void observerTest() {
		TaxiCar taxiCar = new TaxiCar();
		TaxiCar taxiCar1 = new TaxiCar();
		User user = new User();
		user.setTaxi(taxiCar1);
		taxiCar1.addObserver(user);
        taxiCar1.setAvailable(false);
        taxiCar.setAvailable(true);
		//Assertions.assertEquals();
	}

}
