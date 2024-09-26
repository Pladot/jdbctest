package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jdbctest.model.Usuario;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UsuarioController {
    @PostMapping("/usuario")
    public Usuario cadastrar(Usuario usuario) throws SQLException {
        usuario.insert();
        
        return usuario;
    }
    
}
