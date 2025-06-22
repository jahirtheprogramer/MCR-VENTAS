package com.Jr11.crm_ventas.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jr11.crm_ventas.Repository.UsuarioRepository;
import com.Jr11.crm_ventas.model.Usuario;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> autenticar(String email, String password) {
        return usuarioRepository.findByEmail(email)
                .filter(usuario -> usuario.getPassword().equals(password));
    }

    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
