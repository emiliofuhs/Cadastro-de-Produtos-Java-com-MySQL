/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Produto;
import util.DbUtil;

public class ProdutoDao {

    private Connection connection;

    public ProdutoDao() {
        connection = DbUtil.getConnection();
    }

    public void addProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into produtos(nome,veiculo,pesoliquido,pesobruto) values (?, ?, ?, ? )");
            // Parameters start with 1
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getVeiculo());
            preparedStatement.setFloat(3, produto.getPesoLiquido());
            preparedStatement.setFloat(4, produto.getPesoBruto());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduto(int Id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from produtos where id=?");
            // Parameters start with 1
            preparedStatement.setInt(1, Id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateProduto(Produto produto) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update produtos set nome=?, veiculo=?, pesoliquido=?, pesobruto=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setString(2, produto.getVeiculo());
            preparedStatement.setFloat(3, produto.getPesoLiquido());
            preparedStatement.setFloat(4, produto.getPesoBruto());
            preparedStatement.setInt(5, produto.getId());
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produto> getAllProdutos() {
        List<Produto> listaDeProduto = new ArrayList<Produto>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from produtos ORDER BY nome");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setVeiculo(rs.getString("veiculo"));
                produto.setPesoLiquido(rs.getFloat("pesoliquido"));
                produto.setPesoBruto(rs.getFloat("pesobruto"));
                listaDeProduto.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDeProduto;
    }

    public Produto getProdutoById(int Id) {
        Produto produto = new Produto();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from produtos where id=? ");
            preparedStatement.setInt(1, Id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setVeiculo(rs.getString("veiculo"));
                produto.setPesoLiquido(rs.getFloat("pesoliquido"));
                produto.setPesoBruto(rs.getFloat("pesobruto"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produto;
    }
}