package com.ata.ventas.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.ata.ventas.models.ProductoModel;
import com.ata.ventas.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Declara la clase como controlador
@RequestMapping("/productos") // Define la direccion del controlador
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping //Solicitud por pagina
    public ArrayList<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    @PostMapping    //Update de datos
    public ProductoModel crearProducto(@RequestBody ProductoModel producto) {
        return productoService.guardarProducto(producto);
    }

    @GetMapping(path = "{id}")
    public Optional<ProductoModel> obtenerPorId(@PathVariable("id") Long id) {
        return productoService.obtenerPorId(id);
    }

    @DeleteMapping(path = "{id}")
    public String eliminarProductoPorId(@PathVariable("id") Long id) {
        boolean eliminado = productoService.eliminarProducto(id);

        if(eliminado) return "Producto Eliminado";
        else return "Error Eliminando Producto";
    }
}
