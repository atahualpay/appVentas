package com.ata.ventas.services;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.ClienteModel;
import com.ata.ventas.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    //Establece la clase como servidor
public class ClienteService {   //Metodos a utilizar en la logica

    @Autowired  //Inicializa correctamente el objeto
    ClienteRepository clienteRepository;    //Declara un nuevo objeto para el manejo de CRUD
    
    public ClienteModel guardarCliente(ClienteModel cliente) {  //Metodo para guardar cliente en tabla
        return clienteRepository.save(cliente); //Sentencia para guardar el cliente
    }

    public Optional<ClienteModel> obtenerPorId(Long id) {  //Optional ayuda con el manejo de resultados null
        return clienteRepository.findById(id);
    }

    public ArrayList<ClienteModel> obtenerClientes() {
        return (ArrayList<ClienteModel>) clienteRepository.findAll();
    }

    public boolean eliminarCliente(Long id) {
        try {
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
