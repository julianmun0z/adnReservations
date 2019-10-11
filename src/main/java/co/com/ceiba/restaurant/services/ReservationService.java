package co.com.ceiba.restaurant.services;

import java.util.List;
import co.com.ceiba.restaurant.dto.ReservationDto;

public interface ReservationService {

	void addReservation(ReservationDto reservation);

	List<ReservationDto> getReservations();

	ReservationDto getReservationById(int id);

	void edit(ReservationDto reservationDto);
}
