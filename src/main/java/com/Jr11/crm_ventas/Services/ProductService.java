package com.Jr11.crm_ventas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jr11.crm_ventas.Repository.ProductRepository;
import com.Jr11.crm_ventas.model.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productoRepository;

    public List<Product> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Product> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Product guardar(Product producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }

}
