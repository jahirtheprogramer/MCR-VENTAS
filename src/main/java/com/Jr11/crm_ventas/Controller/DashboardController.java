package com.Jr11.crm_ventas.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jr11.crm_ventas.Repository.ClienteRepository;
import com.Jr11.crm_ventas.Repository.ProductRepository;
import com.Jr11.crm_ventas.Repository.ProveedorRepository;
import com.Jr11.crm_ventas.Repository.VentaRepository;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private VentaRepository ventaRepository;

    @GetMapping("/resumen")
    public Map<String, Object> obtenerResumen() {
        Map<String, Object> resumen = new HashMap<>();

        resumen.put("clientes", clienteRepository.count());
        resumen.put("productos", productoRepository.count());
        resumen.put("proveedores", proveedorRepository.count());
        resumen.put("ventasHoy", ventaRepository.totalVentasHoy());

        return resumen;
    }
}
