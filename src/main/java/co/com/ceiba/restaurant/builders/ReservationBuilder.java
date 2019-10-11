package co.com.ceiba.restaurant.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.restaurant.dto.ClientDto;
import co.com.ceiba.restaurant.dto.ReservationDto;
import co.com.ceiba.restaurant.entities.ClientEntity;
import co.com.ceiba.restaurant.entities.ReservationEntity;

@Configuration
public class ReservationBuilder {

	@Autowired
	ClientBuilder clientBuilder;

	public ReservationEntity convertDtoToEntity(ReservationDto reservationDto) {

		ReservationEntity reservationEntity = new ReservationEntity();

		ClientEntity clientEntity = clientBuilder.convertDtoToEntity(reservationDto.getClientDto());

		reservationEntity.setIdReservation(reservationDto.getIdReservation());
		reservationEntity.setReservationDate(reservationDto.getReservationDate());
		reservationEntity.setNumberPeople(reservationDto.getNumberPeople());
		reservationEntity.setDecor(reservationDto.isDecor());
		reservationEntity.setClientEntity(clientEntity);

		return reservationEntity;
	}

	public ReservationDto convertEntityToDto(ReservationEntity reservationEntity) {

		ReservationDto reservationDto = new ReservationDto();

		ClientDto clientDto = clientBuilder.convertEntityToDto(reservationEntity.getClientEntity());

		reservationDto.setIdReservation(reservationEntity.getIdReservation());
		reservationDto.setReservationDate(reservationEntity.getReservationDate());
		reservationDto.setNumberPeople(reservationEntity.getNumberPeople());
		reservationDto.setDecor(reservationEntity.isDecor());
		reservationDto.setClientDto(clientDto);

		return reservationDto;
	}

}
