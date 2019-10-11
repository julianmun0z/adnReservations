package co.com.ceiba.restaurant.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurant.dto.BillDto;
import co.com.ceiba.restaurant.dto.ReservationDto;
import co.com.ceiba.restaurant.entities.BillEntity;
import co.com.ceiba.restaurant.entities.ReservationEntity;

@Configuration
public class BillBuilder {

	@Autowired
	ReservationBuilder reservationBuilder;

	public BillEntity converDtoToEntity(BillDto billDto) {

		BillEntity billEntity = new BillEntity();

		ReservationEntity reservationEntity = reservationBuilder.convertDtoToEntity(billDto.getReservationDto());

		billEntity.setBillId(billDto.getBillId());
		billEntity.setPrice(billDto.getPrice());
		billEntity.setDiscountForPeople(billDto.getDiscountForPeople());
		billEntity.setDiscpuntForDays(billDto.getDiscpuntForDays());
		billEntity.setReservationEntity(reservationEntity);

		return billEntity;
	}

	public BillDto convertEntityToDto(BillEntity billEntity) {

		BillDto billDto = new BillDto();

		ReservationDto reservationDto = reservationBuilder.convertEntityToDto(billEntity.getReservationEntity());

		billDto.setBillId(billEntity.getBillId());
		billDto.setPrice(billEntity.getPrice());
		billDto.setDiscountForPeople(billEntity.getDiscountForPeople());
		billDto.setDiscpuntForDays(billEntity.getDiscpuntForDays());
		billDto.setReservationDto(reservationDto);

		return billDto;

	}

}
