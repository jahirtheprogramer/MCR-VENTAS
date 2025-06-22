package com.Jr11.crm_ventas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Jr11.crm_ventas.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT COALESCE(SUM(v.total), 0) FROM Venta v WHERE DATE(v.fecha) = CURRENT_DATE")
    Double totalVentasHoy();
}
