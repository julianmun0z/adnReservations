package co.com.ceiba.restaurant.testcontrollers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import co.com.ceiba.restaurant.dto.BillDto;
import co.com.ceiba.restaurant.entities.BillEntity;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BillTestController {
	
	private static final float PRICE = 350000;
	private static final int DISCOUNTFORPEOPLE = 15;
	private static final int DISCOUNTFORDAYS = 20;
	
	@Autowired
	private MockMvc mvc;
	
	@InjectMocks
	BillDto billDto = new BillDto();
	@InjectMocks
	BillEntity billEntity = new BillEntity();

 	
	@Test
	public void createReservation() throws Exception
	{
		
		
		billDto.setPrice(PRICE);
		billDto.setDiscountForPeople(DISCOUNTFORPEOPLE);
		billDto.setDiscpuntForDays(DISCOUNTFORDAYS);
		billEntity.setPrice(billDto.getPrice());
		billEntity.setDiscountForPeople(billDto.getDiscountForPeople());
		billEntity.setDiscpuntForDays(billDto.getDiscpuntForDays());
		
		
	}
	
	@Test
	public void getBill() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/bill")
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());  
	}
	
	@Test
	public void getReservationId() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .get("/reservation/{id}", 1)
	      .accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
	}
	
	@Test
	public void updateBill() throws Exception
	{
	  mvc.perform( MockMvcRequestBuilders
	      .put("/bill/{id}", 2)
	      .content(asJsonString(billEntity))
	      .contentType(MediaType.APPLICATION_JSON)
	      .accept(MediaType.APPLICATION_JSON));
	      
	}

	private byte[] asJsonString(BillEntity billEntity2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
