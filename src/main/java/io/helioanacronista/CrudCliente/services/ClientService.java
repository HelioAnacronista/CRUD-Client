package io.helioanacronista.CrudCliente.services;

import io.helioanacronista.CrudCliente.dto.ClientDTO;
import io.helioanacronista.CrudCliente.entities.Client;
import io.helioanacronista.CrudCliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional()
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).get();
        return new ClientDTO(client);
    }
}
