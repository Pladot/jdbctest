package com.example.jdbctest.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.jdbctest.model.Produto;
import com.example.jdbctest.model.Usuario;

import java.sql.SQLException;

import org.springframework.web.bind.annotation.PostMapping;



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
}


