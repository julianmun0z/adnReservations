package co.com.ceiba.restaurant.dao;

import java.util.List;

import org.springframework.data.repository.Repository;

import co.com.ceiba.restaurant.entities.BillEntity;

public interface BillDao extends Repository<BillEntity, Integer> {

	void save(BillEntity billEntity);

	List<BillEntity> findAll();

	BillEntity findById(int id);

	void delete(BillEntity billEntity);

}
