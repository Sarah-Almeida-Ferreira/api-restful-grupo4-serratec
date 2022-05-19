package org.serratec.lojasAmazonas.services;

import java.util.Optional;

import org.serratec.lojasAmazonas.entities.ClienteEntity;
import org.serratec.lojasAmazonas.repositories.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	IClienteRepository clienteRepository;
	
	public ClienteEntity getById(Long id) {
		Optional<ClienteEntity> cliente = clienteRepository.findById(id);

		if (cliente.isEmpty()) {
			return null;
		}

		return cliente.get();
	}
	
	public ClienteEntity create(ClienteEntity entity) {

		return clienteRepository.save(entity);
	}

}
