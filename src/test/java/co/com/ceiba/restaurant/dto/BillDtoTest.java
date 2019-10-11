package co.com.ceiba.restaurant.dto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;

import co.com.ceiba.restaurant.testdatabuilder.BillDtoTestbuilder;

public class BillDtoTest {


	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	@InjectMocks
	private BillDto billDto = new BillDto();
	
	@Test
	public void createBillTest() {
		
		// arrange
		BillDtoTestbuilder billDtoTestbuilder = new BillDtoTestbuilder()
				.whitePrice(PRICE)
				.whiteDiscountForPeople(DISCOUNTFORPEOPLE)
				.whiteDiscountForDays(DISCOUNTFORDAYS);
		
		//act
		BillDto billDto = billDtoTestbuilder.build();
		
		//assert
	
		assertEquals(PRICE, billDto.getPrice(),0);
		assertEquals(DISCOUNTFORPEOPLE, billDto.getDiscountForPeople());
		assertEquals(DISCOUNTFORDAYS, billDto.getDiscpuntForDays());
	}
	
}
