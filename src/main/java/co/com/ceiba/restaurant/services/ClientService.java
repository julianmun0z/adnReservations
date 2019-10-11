package co.com.ceiba.restaurant.services;

import java.util.List;
import co.com.ceiba.restaurant.dto.ClientDto;

public interface ClientService {

	void addClient(ClientDto client);

	List<ClientDto> getClients();

	ClientDto getClientById(int id);

	void edit(ClientDto clientDto);

}
