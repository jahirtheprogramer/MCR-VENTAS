package com.Jr11.crm_ventas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jr11.crm_ventas.Repository.VentaRepository;
import com.Jr11.crm_ventas.model.Venta;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public Venta guardarVenta(Venta venta) {
        // Al guardar la Venta, JPA se encargará de persistir los DetalleVenta por cascada.
        return ventaRepository.save(venta);
    }

    @Override
    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta obtenerVentaPorId(Long id) {
        Optional<Venta> opt = ventaRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public void eliminarVenta(Long id) {
        ventaRepository.deleteById(id);
    }
}
