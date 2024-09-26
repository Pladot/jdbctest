package com.example.jdbctest.model;

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

    public void insert() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "INSERT into usuario " + "(id,nome) " + "VALUES (?,?)";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setInt(1, this.id);
        ps.setString(2, this.nome);
        ps.executeUpdate();
    }

    public void update() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE usuario " + "SET nome = ? WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setString(1, this.nome);
        ps.setInt(2, this.id);
        ps.executeUpdate();
    }

    public void delete() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "DELETE FROM usuario WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setInt(1, this.id);
        ps.executeUpdate();
    }

    public static ArrayList<Usuario> getAll() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        Statement st = dbConn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuarios.add(usuario);
            }
        return usuarios;    
    }

    public void load() throws SQLException{
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "SELECT * FROM usuario WHERE id = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);

        ps.setInt(1, this.id);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            this.nome = rs.getString("nome");
        }
    
    }
}
