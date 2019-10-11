package co.com.ceiba.restaurant.dao;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.restaurant.entities.ClientEntity;

@Transactional
public interface ClientDao extends Repository<ClientEntity, Integer> {

	void save(ClientEntity clientEntity);

	List<ClientEntity> findAll();

	ClientEntity findById(int id);

}
