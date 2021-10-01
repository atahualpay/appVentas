package com.ata.ventas.repositories;

import com.ata.ventas.models.ProductoModel;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<ProductoModel, Long>{    //Define interface CRUD para gestionar datos de la tabla productos
    
}
