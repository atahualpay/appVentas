package com.ata.ventas.repositories;

import com.ata.ventas.models.ClienteModel;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<ClienteModel, Long> { //Define interface CRUD para gestionar datos de la tabla clientes
    
}
