package com.ata.ventas.repositories;

import com.ata.ventas.models.VentaModel;

import org.springframework.data.repository.CrudRepository;

public interface VentaRepository extends CrudRepository<VentaModel, Long> {     //Define interface CRUD para gestionar datos de la tabla ventas
    
}
