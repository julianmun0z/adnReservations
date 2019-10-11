package co.com.ceiba.restaurant.builders;

import org.springframework.context.annotation.Configuration;
import co.com.ceiba.restaurant.dto.ClientDto;
import co.com.ceiba.restaurant.entities.ClientEntity;

@Configuration
public class ClientBuilder {

	public ClientEntity convertDtoToEntity(ClientDto client) {

		ClientEntity clientEntity = new ClientEntity();

		clientEntity.setClientId(client.getClientId());
		clientEntity.setFirstName(client.getFirstName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setEmail(client.getEmail());
		clientEntity.setPhoneNumber(client.getPhoneNumber());

		return clientEntity;
	}

	public ClientDto convertEntityToDto(ClientEntity clientEntity) {

		ClientDto clientDto = new ClientDto();

		clientDto.setClientId(clientEntity.getClientId());
		clientDto.setFirstName(clientEntity.getFirstName());
		clientDto.setLastName(clientEntity.getLastName());
		clientDto.setEmail(clientEntity.getEmail());
		clientDto.setPhoneNumber(clientEntity.getPhoneNumber());

		return clientDto;
	}

}
