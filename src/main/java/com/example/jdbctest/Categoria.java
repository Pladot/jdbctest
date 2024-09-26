package com.example.jdbctest;

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

    public void update(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE categoria SET descricao = ? WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setString(1, this.descricao);
            ps.setInt(2, this.id);
            ps.executeUpdate();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "DELETE FROM categoria WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Categoria> getAll(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categoria";

        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categorias;
    }

    public void load(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "SELECT * FROM categoria WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);
    
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                this.descricao = rs.getString("descricao");
            }    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
