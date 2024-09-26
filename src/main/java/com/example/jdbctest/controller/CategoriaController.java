package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import com.example.jdbctest.model.Categoria;



@RestController
public class CategoriaController {
    @PostMapping("categoria/cadastrar")
    public Categoria cadastrar(Categoria categoria) throws SQLException{
        categoria.insert();
        
        return categoria;
    }

    @PostMapping("categoria/atualizar")
    public Categoria update(Categoria categoria) throws SQLException{
        categoria.update();
        
        return categoria;
    }
    
}
