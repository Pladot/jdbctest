package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jdbctest.model.Usuario;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
public class UsuarioController {
    @PostMapping("/usuario/cadastrar")
    public Usuario cadastrar(Usuario usuario) throws SQLException {
        usuario.insert();
        
        return usuario;
    }

    @PostMapping("usuario/atualizar")
    public Usuario atualizar(Usuario usuario) throws SQLException{
        usuario.update();        

        return usuario;
    }    
    
}
