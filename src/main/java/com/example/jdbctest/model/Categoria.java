package com.example.jdbctest.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

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

    public void insert() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT INTO categoria (id,descricao) VALUES (?,?)";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setInt(1, this.id);
        ps.setString(2, this.descricao);
        ps.executeUpdate();
    }

    public void update() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setString(1, this.descricao);
        ps.setInt(2, this.id);
        ps.executeUpdate();  
    }

    public void delete() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "DELETE FROM categoria WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setInt(1, this.id);
        ps.executeUpdate();
    }

    public static ArrayList<Categoria> getAll() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        Statement st = dbConn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()){
            Categoria categoria = new Categoria();

            categoria.setId(rs.getInt("id"));
            categoria.setDescricao(rs.getString("descricao"));
            categorias.add(categoria);
            }
        return categorias;
    }

    public void load() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "SELECT * FROM categoria WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);
    
        ps.setInt(1, this.id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            this.descricao = rs.getString("descricao");
        }    
    }
}