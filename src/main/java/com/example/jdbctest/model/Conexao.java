package com.example.jdbctest.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {
    private String banco = "lojinha";
    private String usuario = "root";
    private String senha = "";

    public Connection getConexao(){

        String conecta = "jdbc:mysql://localhost:3306/" + banco;
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(conecta, usuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conexao;
    }
}
