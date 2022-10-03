package io.helioanacronista.CrudCliente.services;

import io.helioanacronista.CrudCliente.dto.ClientDTO;
import io.helioanacronista.CrudCliente.entities.Client;
import io.helioanacronista.CrudCliente.repositories.ClientRepository;
import io.helioanacronista.CrudCliente.services.exceptions.DataBaseNotFoundException;
import io.helioanacronista.CrudCliente.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client();

        copyToEntityDTO(dto, entity);

        entity = repository.save(entity);
        return new ClientDTO(entity);
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        try {

            Client entity = repository.getReferenceById(id);
            copyToEntityDTO(dto, entity);
            entity = repository.save(entity);
            return new ClientDTO(entity);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recuso não encontrado.");
        }

    }

    @Transactional
    public void delete(Long id) {
        try {

            repository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recuso não encontrado.");
        } catch (DataIntegrityViolationException e) {
            throw new DataBaseNotFoundException("Falha de integridade refencial.");
        }

    }

    private void copyToEntityDTO(ClientDTO dto, Client entity) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }
}
