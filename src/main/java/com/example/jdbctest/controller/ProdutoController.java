package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jdbctest.model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@CrossOrigin(origins = "*")
@RestController
public class ProdutoController {
    @PostMapping("produto/cadastrar")
    public Produto cadastrar(Produto produto) throws SQLException{
        produto.insert();
        
        return produto;
    }

    @PostMapping("produto/atualizar")
    public Produto atualizar(Produto produto) throws SQLException{
        produto.update();        

        return produto;
    }

    @PostMapping("produto/deletar")
    public Produto deletar(Produto produto) throws SQLException{
        produto.delete();

        return produto;
    }

    @GetMapping("produto")
    public ArrayList<Produto> getAllProduto(Produto produto) throws SQLException{
        
        return Produto.getAll();
    }

    @GetMapping("produto/{id}")
    public Produto getOne(@PathVariable int id) throws SQLException{
        Produto produto = new Produto();
        produto.setId(id);
        produto.load();

        return produto;
    }
}


