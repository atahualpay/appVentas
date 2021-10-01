package com.ata.ventas.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.ClienteModel;
import com.ata.ventas.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Declara la clase como controlador
@RequestMapping("/clientes") // Define la direccion del controlador
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping //Solicitud por pagina
    public ArrayList<ClienteModel> obtenerClientes() {
        return clienteService.obtenerClientes();
    }

    @PostMapping    //Update de datos
    public ClienteModel crearCliente(@RequestBody ClienteModel cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping(path = "{id}")
    public Optional<ClienteModel> obtenerPorId(@PathVariable("id") Long id) {
        return clienteService.obtenerPorId(id);
    }

    @DeleteMapping(path = "{id}")
    public String eliminarClientePorId(@PathVariable("id") Long id) {
        boolean eliminado = clienteService.eliminarCliente(id);

        if(eliminado) return "Cliente Eliminado";
        else return "Error Eliminando Cliente";
    }
}
