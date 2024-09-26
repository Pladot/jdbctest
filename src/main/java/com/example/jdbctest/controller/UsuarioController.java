package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jdbctest.model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UsuarioController {
    @PostMapping("usuario/cadastrar")
    public Usuario cadastrar(Usuario usuario) throws SQLException {
        usuario.insert();
        
        return usuario;
    }

    @PostMapping("usuario/atualizar")
    public Usuario atualizar(Usuario usuario) throws SQLException{
        usuario.update();        

        return usuario;
    }
        
    @PostMapping("usuario/deletar")
    public Usuario deletar(Usuario usuario) throws SQLException{
        usuario.delete();

        return usuario;
    }

    @GetMapping("usuarios")
    public ArrayList<Usuario> getAllUsuario(Usuario usuario) throws SQLException{
        
        return Usuario.getAll();
    }
    
    
}
