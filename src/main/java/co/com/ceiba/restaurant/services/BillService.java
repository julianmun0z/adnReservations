package co.com.ceiba.restaurant.services;

import java.util.List;

import co.com.ceiba.restaurant.dto.BillDto;
import co.com.ceiba.restaurant.dto.FullReservationDto;

public interface BillService {

	void addBill(BillDto billDto);

	List<BillDto> getBills();

	BillDto getBillById(int id);

	void edit(BillDto billDto);

	void addBillFull(FullReservationDto fullResevationDto);

	BillDto delete(int id);

	void editfull(FullReservationDto fullReservationDto);

}
