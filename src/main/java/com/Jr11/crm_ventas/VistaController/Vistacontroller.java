package com.Jr11.crm_ventas.VistaController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  // Asegúrate de que exista este servicio
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Jr11.crm_ventas.Services.ClienteService;
import com.Jr11.crm_ventas.Services.ProductService;
import com.Jr11.crm_ventas.Services.ProveedorService;

@Controller
public class Vistacontroller {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("/")
    public String index() {
        return "index";  // Aquí se busca un archivo index.html en src/main/resources/templates
    }

    @GetMapping("/Clientes")
    public String vistaClientes(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodos());
        return "Clientes";
    }

    @GetMapping("/Productos")
    public String vistaProductos(Model model) {
        model.addAttribute("Productos", productService.obtenerTodos());
        return "Productos";
    }

    @GetMapping("/Proveedor")
    public String vistaProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.obtenerTodos());
        return "Proveedor";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/Venta")
    public String mostrarPaginaVentas() {
        return "Venta";
    }

    @GetMapping("/presentacion")
    public String showPresentacion() {
        return "presentacion";
    }

}
