package com.Jr11.crm_ventas.dto;

import java.util.ArrayList;
import java.util.List;

import com.Jr11.crm_ventas.model.DetalleVenta;
import com.Jr11.crm_ventas.model.Product;
import com.Jr11.crm_ventas.model.Usuario;
import com.Jr11.crm_ventas.model.Venta;

public class VentaResponseDTO {

    private Long id;
    private String fecha;           // Formatearemos fecha como cadena ISO
    private double total;
    private UsuarioDTO usuario;     // Solo con id y nombre
    private List<DetalleDTO> detalles = new ArrayList<>();

    public VentaResponseDTO() {
    }

    public VentaResponseDTO(Venta venta) {
        this.id = venta.getId();
        // Suponiendo que “venta.getFecha()” retorna un LocalDateTime o Date
        this.fecha = venta.getFecha().toString();
        this.total = venta.getTotal();  // Suponiendo que tu entidad Venta tenga un getter getTotal()

        // UsuarioDTO con id y nombre
        Usuario u = venta.getUsuario();
        this.usuario = new UsuarioDTO(u.getId(), u.getNombre());

        // Rellenamos la lista de detalles
        for (DetalleVenta dv : venta.getDetalles()) {
            Product p = dv.getProducto();
            DetalleDTO detalleDTO = new DetalleDTO(
                    p.getId(),
                    p.getNombre(),
                    dv.getCantidad(),
                    dv.getPrecioUnitario(),
                    dv.getCantidad() * dv.getPrecioUnitario()
            );
            this.detalles.add(detalleDTO);
        }
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public List<DetalleDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleDTO> detalles) {
        this.detalles = detalles;
    }

    // Mini DTO para el usuario (solo id y nombre)
    public static class UsuarioDTO {

        private Long id;
        private String nombre;

        public UsuarioDTO() {
        }

        public UsuarioDTO(Long id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    }

    // DTO para cada línea de detalle
    public static class DetalleDTO {

        private Long productoId;
        private String productoNombre;
        private int cantidad;
        private double precioUnitario;
        private double subtotal;

        public DetalleDTO() {
        }

        public DetalleDTO(Long productoId, String productoNombre, int cantidad,
                double precioUnitario, double subtotal) {
            this.productoId = productoId;
            this.productoNombre = productoNombre;
            this.cantidad = cantidad;
            this.precioUnitario = precioUnitario;
            this.subtotal = subtotal;
        }

        public Long getProductoId() {
            return productoId;
        }

        public void setProductoId(Long productoId) {
            this.productoId = productoId;
        }

        public String getProductoNombre() {
            return productoNombre;
        }

        public void setProductoNombre(String productoNombre) {
            this.productoNombre = productoNombre;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }

        public double getPrecioUnitario() {
            return precioUnitario;
        }

        public void setPrecioUnitario(double precioUnitario) {
            this.precioUnitario = precioUnitario;
        }

        public double getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(double subtotal) {
            this.subtotal = subtotal;
        }
    }
}
