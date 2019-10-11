package co.com.ceiba.restaurant.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.restaurant.builders.BillBuilder;
import co.com.ceiba.restaurant.dao.BillDao;
import co.com.ceiba.restaurant.dao.ClientDao;
import co.com.ceiba.restaurant.dao.ReservationDao;
import co.com.ceiba.restaurant.dto.BillDto;
import co.com.ceiba.restaurant.dto.FullReservationDto;
import co.com.ceiba.restaurant.entities.BillEntity;
import co.com.ceiba.restaurant.services.BillService;
import co.com.ceiba.restaurant.strategies.FullReservationStrategy;

@Service
public class DefaultBillService implements BillService {

	@Autowired
	BillBuilder billBuilder;

	@Autowired
	private BillDao billDao;

	@Autowired
	private ReservationDao reservationDao;

	@Autowired
	private ClientDao clientDao;

	@Autowired
	FullReservationStrategy fullReservationStrategy;

	@Override
	public void addBill(BillDto billDto) {
		BillEntity billEntity = billBuilder.converDtoToEntity(billDto);
		billDao.save(billEntity);
	}

	@Override
	public List<BillDto> getBills() {
		List<BillDto> bills = new ArrayList<>();
		List<BillEntity> entities = billDao.findAll();
		for (BillEntity billEntity : entities) {
			BillDto billDto = billBuilder.convertEntityToDto(billEntity);
			bills.add(billDto);
		}
		return bills;
	}

	@Override
	public BillDto getBillById(int id) {
		BillEntity billEntity = billDao.findById(id);
		BillDto billDto = billBuilder.convertEntityToDto(billEntity);
		return billDto;
	}

	@Override
	public void addBillFull(FullReservationDto fullResevationDto) {
		BillDto billDto = fullReservationStrategy.divisionDtoToClient(fullResevationDto);
		BillEntity billEntity = billBuilder.converDtoToEntity(billDto);
		clientDao.save(billEntity.getReservationEntity().getClientEntity());
		reservationDao.save(billEntity.getReservationEntity());

		billDao.save(billEntity);
	}

	@Override
	public void edit(BillDto billDto) {
		BillEntity billEntity = billBuilder.converDtoToEntity(billDto);
		billDao.save(billEntity);

	}

	@Override
	public void editfull(FullReservationDto fullReservationDto) {
		BillDto billDto = fullReservationStrategy.divisionDtoToClient(fullReservationDto);
		BillEntity billEntity = billBuilder.converDtoToEntity(billDto);
		clientDao.save(billEntity.getReservationEntity().getClientEntity());
		reservationDao.save(billEntity.getReservationEntity());

		billDao.save(billEntity);

	}

	@Override
	public BillDto delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}