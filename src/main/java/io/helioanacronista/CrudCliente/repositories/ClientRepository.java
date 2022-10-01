package io.helioanacronista.CrudCliente.repositories;

import io.helioanacronista.CrudCliente.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
