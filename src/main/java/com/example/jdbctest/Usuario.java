package com.example.jdbctest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Usuario {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void insert(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT into usuario " + "(id,nome) " + "VALUES (?,?)";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.setString(2, this.nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void update(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE usuario " + "SET nome = ? WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setString(1, this.nome);
            ps.setInt(2, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Usuario> getAll(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Usuario usuario = new Usuario();

                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;

    }
    
}
