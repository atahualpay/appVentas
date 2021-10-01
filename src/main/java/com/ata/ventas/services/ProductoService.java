package com.ata.ventas.services;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.ProductoModel;
import com.ata.ventas.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    
    @Autowired  //Inicializa correctamente el objeto
    ProductoRepository productoRepository;    //Declara un nuevo objeto para el manejo de CRUD
    
    public ProductoModel guardarProducto(ProductoModel producto) {  //Metodo para guardar cliente en tabla
        return productoRepository.save(producto); //Sentencia para guardar el cliente
    }

    public Optional<ProductoModel> obtenerPorId(Long id) {  //Optional ayuda con el manejo de resultados null
        return productoRepository.findById(id);
    }

    public ArrayList<ProductoModel> obtenerProductos() {
        return (ArrayList<ProductoModel>) productoRepository.findAll();
    }

    public boolean eliminarProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
