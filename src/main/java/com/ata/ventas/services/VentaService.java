package com.ata.ventas.services;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.VentaModel;
import com.ata.ventas.repositories.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService {
    
    @Autowired  //Inicializa correctamente el objeto
    VentaRepository ventaRepository;    //Declara un nuevo objeto para el manejo de CRUD
    
    public VentaModel guardarVenta(VentaModel venta) {  //Metodo para guardar cliente en tabla
        return ventaRepository.save(venta); //Sentencia para guardar el cliente
    }

    public Optional<VentaModel> obtenerPorId(Long id) {  //Optional ayuda con el manejo de resultados null
        return ventaRepository.findById(id);
    }

    public ArrayList<VentaModel> obtenerVentas() {
        return (ArrayList<VentaModel>) ventaRepository.findAll();
    }

    public boolean eliminarVenta(Long id) {
        try {
            ventaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}