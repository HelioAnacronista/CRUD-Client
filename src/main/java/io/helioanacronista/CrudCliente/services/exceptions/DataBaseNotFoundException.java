package io.helioanacronista.CrudCliente.services.exceptions;

public class DataBaseNotFoundException extends RuntimeException{

    public DataBaseNotFoundException(String msg) {
        super(msg);
    }

}
