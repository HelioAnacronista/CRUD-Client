package io.helioanacronista.CrudCliente.controllers;

import io.helioanacronista.CrudCliente.entities.Client;
import io.helioanacronista.CrudCliente.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/clients")
public class ClientControllers {

    @Autowired
    private ClientRepository repository;

    //Testar o repository
    @GetMapping(value = "/{id}")
    public String findById(@PathVariable Long id) {
        Optional<Client> result = repository.findById(id);
        Client product = result.get();
        return product.getName();
    }
}
