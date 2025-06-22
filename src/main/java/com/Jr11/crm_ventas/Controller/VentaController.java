package com.Jr11.crm_ventas.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jr11.crm_ventas.Repository.ProductRepository;
import com.Jr11.crm_ventas.Repository.UsuarioRepository;
import com.Jr11.crm_ventas.Services.VentaService;
import com.Jr11.crm_ventas.dto.VentaDTO;
import com.Jr11.crm_ventas.dto.VentaResponseDTO;
import com.Jr11.crm_ventas.model.DetalleVenta;
import com.Jr11.crm_ventas.model.Product;
import com.Jr11.crm_ventas.model.Usuario;
import com.Jr11.crm_ventas.model.Venta;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * LISTAR TODAS LAS VENTAS *
     */
    @GetMapping
    public ResponseEntity<List<VentaResponseDTO>> listarVentas() {
        List<Venta> ventas = ventaService.listarVentas();
        // Convertimos cada entidad Venta a su DTO de respuesta
        List<VentaResponseDTO> dtos = ventas.stream()
                .map(VentaResponseDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    /**
     * OBTENER UNA VENTA POR ID (para “Ver Detalles”) *
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerVentaPorId(@PathVariable Long id) {
        Venta venta = ventaService.obtenerVentaPorId(id);
        if (venta == null) {
            return ResponseEntity
                    .status(404)
                    .body("Venta no encontrada con id: " + id);
        }
        return ResponseEntity.ok(new VentaResponseDTO(venta));
    }

    /**
     * CREAR UNA NUEVA VENTA *
     */
    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody VentaDTO ventaDTO) {
        // 1. Buscamos el usuario (quien hace la venta)
        Usuario usuario = usuarioRepository.findById(ventaDTO.getUsuarioId())
                .orElse(null);
        if (usuario == null) {
            return ResponseEntity.badRequest()
                    .body("Usuario no encontrado con id: " + ventaDTO.getUsuarioId());
        }

        // 2. Creamos la entidad Venta
        Venta venta = new Venta();
        venta.setUsuario(usuario);

        // 3. Recorremos cada detalle del DTO y lo agregamos a la entidad
        for (VentaDTO.DetalleDTO d : ventaDTO.getDetalles()) {
            Product producto = productRepository.findById(d.getProductoId())
                    .orElse(null);
            if (producto == null) {
                return ResponseEntity.badRequest()
                        .body("Producto no encontrado con id: " + d.getProductoId());
            }
            DetalleVenta detalle = new DetalleVenta();
            detalle.setProducto(producto);
            detalle.setCantidad(d.getCantidad());
            detalle.setPrecioUnitario(d.getPrecioUnitario());

            venta.addDetalle(detalle);
        }

        // 4. Guardamos la venta
        Venta ventaGuardada = ventaService.guardarVenta(venta);

        // 5. Devolvemos el DTO de respuesta (con id, fecha, total, usuario, detalles)
        return ResponseEntity.ok(new VentaResponseDTO(ventaGuardada));
    }
}
