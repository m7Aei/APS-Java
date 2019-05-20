package models.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.bean.multasCarros;

public class multasDAO {
    public void create (multasCarros multaCarro) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("INSERT INTO multas (valorMulta, nome, cpf, tipoMulta, placaVeiculo)"
            + "VALUES(?, ?, ?, ?, ?)");

            stmt.setFloat(1, multaCarro.getValorMulta());
            stmt.setString(2, multaCarro.getNome());
            stmt.setString(3, multaCarro.getCpf());
            stmt.setString(4, multaCarro.getTipoMulta());
            stmt.setString(5, multaCarro.getPlacaVeiculo());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Multa cadastrada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar a multa!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
    
    public List<multasCarros> read() {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<multasCarros> listaInformacoes = new ArrayList<>();
        
        try {
            stmt = connect.prepareStatement("SELECT * FROM multas");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                multasCarros informations = new multasCarros();
                
                informations.setID_Multa(rs.getInt("ID_Multa"));
                informations.setNome(rs.getString("nome"));
                informations.setCpf(rs.getString("cpf"));
                informations.setPlacaVeiculo(rs.getString("placaVeiculo"));
                informations.setTipoMulta(rs.getString("tipoMulta"));
                informations.setValorMulta(rs.getFloat("valorMulta"));
                
                listaInformacoes.add(informations);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar a lista!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, rs);
        }
        
        return listaInformacoes;
    }
    
    public void update(multasCarros attMulta) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connect.prepareStatement("UPDATE multas SET nome = ?, cpf = ? WHERE ID_Multa = ?");
            
            stmt.setString(1, attMulta.getNome());
            stmt.setString(2, attMulta.getCpf());
            stmt.setInt(3, attMulta.getID_Multa());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao atualizar as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
}