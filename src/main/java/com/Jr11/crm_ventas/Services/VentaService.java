package com.Jr11.crm_ventas.Services;

import java.util.List;

import com.Jr11.crm_ventas.model.Venta;

public interface VentaService {

    Venta guardarVenta(Venta venta);

    List<Venta> listarVentas();

    Venta obtenerVentaPorId(Long id);

    void eliminarVenta(Long id);
}
