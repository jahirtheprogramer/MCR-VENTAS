package com.Jr11.crm_ventas.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jr11.crm_ventas.Services.ProductService;
import com.Jr11.crm_ventas.model.Product;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductService productoService;

    @GetMapping
    public List<Product> obtenerTodos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Product> obtenerPorId(@PathVariable Long id) {
        return productoService.obtenerPorId(id);
    }

    @PostMapping
    public Product guardar(@RequestBody Product producto) {
        return productoService.guardar(producto);
    }

    @PutMapping("/{id}")
    public Product actualizar(@PathVariable Long id, @RequestBody Product productoActualizado) {
        return productoService.obtenerPorId(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setCantidad(productoActualizado.getCantidad());
            producto.setDescripcion(productoActualizado.getDescripcion());
            return productoService.guardar(producto);
        }).orElseGet(() -> {
            productoActualizado.setId(id);
            return productoService.guardar(productoActualizado);
        });
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoService.eliminar(id);
    }
}
