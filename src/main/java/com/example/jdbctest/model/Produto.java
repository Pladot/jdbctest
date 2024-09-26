package com.example.jdbctest.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class Produto {
    private int id;
    private float valor;
    private String nome;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
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

        String sql = "INSERT INTO produto (id,valor,nome) VALUES (?,?,?)";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ps.setFloat(2, this.valor);
            ps.setString(3, this.nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "UPDATE produto SET valor = ?, nome = ? WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setFloat(1, this.valor);
            ps.setString(2, this.nome);
            ps.setInt(3, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "DELETE FROM produto WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Produto> getAll(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try {
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setValor(rs.getFloat("valor"));
                produto.setNome(rs.getString("nome"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }

    public void load(){
        Conexao c = new Conexao();
        Connection dbConn = c.getConexao();

        String sql = "SELECT * FROM produto WHERE id = ?";

        try {
            PreparedStatement ps = dbConn.prepareStatement(sql);

            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                this.nome = rs.getString("nome");
                this.valor = rs.getFloat("valor");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
