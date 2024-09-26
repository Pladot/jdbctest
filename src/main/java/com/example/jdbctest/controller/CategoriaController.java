package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

import java.util.ArrayList;

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
    
    @PostMapping("categoria/deletar")
    public Categoria deletar(Categoria categoria) throws SQLException{
        categoria.delete();
        
        return categoria;
    }
    
    @GetMapping("categoria")
    public ArrayList<Categoria> getAllCategoria(Categoria categoria) throws SQLException{
        
        return Categoria.getAll();
    }

    @GetMapping("categoria/{id}")
    public Categoria getOne(@PathVariable int id) throws SQLException{
        Categoria categoria = new Categoria();
        categoria.setId(id);
        categoria.load();

        return categoria;
    }
    
}
