package com.example.jdbctest;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Categoria {
    private int id;
    private String descricao;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void insert(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT INTO categoria (id,descricao) VALUES (?,?)";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.setString(2, this.descricao);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
