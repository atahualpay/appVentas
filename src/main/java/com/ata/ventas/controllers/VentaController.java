package com.ata.ventas.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.VentaModel;
import com.ata.ventas.services.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Declara la clase como controlador
@RequestMapping("/ventas") // Define la direccion del controlador
public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping //Solicitud por pagina
    public ArrayList<VentaModel> obtenerVentas() {
        return ventaService.obtenerVentas();
    }

    @PostMapping    //Update de datos
    public VentaModel crearCliente(@RequestBody VentaModel cliente) {
        return ventaService.guardarVenta(cliente);
    }

    @GetMapping(path = "{id}")
    public Optional<VentaModel> obtenerPorId(@PathVariable("id") Long id) {
        return ventaService.obtenerPorId(id);
    }

    @DeleteMapping(path = "{id}")
    public String eliminarVentaPorId(@PathVariable("id") Long id) {
        boolean eliminado = ventaService.eliminarVenta(id);

        if(eliminado) return "Venta Eliminada";
        else return "Error Eliminando Venta";
    }
}
