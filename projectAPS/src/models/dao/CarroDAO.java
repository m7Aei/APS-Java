package models.dao;

import connection.ConnectionFactory;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.bean.informacoesCarro;

// classe principal do programa 
public class CarroDAO {
    // metodo que cadastrada um novo carro no banco de dados
    public void create (informacoesCarro informationCars) {
        Connection connect = ConnectionFactory.getConnection();  
        PreparedStatement stmt = null;
        
        try {
            stmt = connect.prepareStatement("INSERT INTO informacoes_carro (modelo, dono, cor, anoDoCarro, placa)" 
            + "VALUES(?, ?, ?, ?, ?)");
            
            stmt.setString(1, informationCars.getModelo());
            stmt.setString(2, informationCars.getDono());
            stmt.setString(3, informationCars.getCor());
            stmt.setInt(4, informationCars.getAnoDoCarro());
            stmt.setString(5, informationCars.getPlaca());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Informações salvas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao salvar as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
    
    // metodo para retornar uma array list com os carros ja cadastrados dentro da tabela 
    public List<informacoesCarro> read() {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<informacoesCarro> listaInformacoes = new ArrayList<>();
        
        try {
            stmt = connect.prepareStatement("SELECT * FROM informacoes_carro");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                informacoesCarro informations = new informacoesCarro();
                
                informations.setID_Carro(rs.getInt("ID_Carro"));
                informations.setDono(rs.getString("dono"));
                informations.setAnoDoCarro(rs.getInt("anoDoCarro"));
                informations.setCor(rs.getString("cor"));
                informations.setModelo(rs.getString("modelo"));
                informations.setPlaca(rs.getString("placa"));
                
                listaInformacoes.add(informations);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar a lista!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, rs);
        }
        
        return listaInformacoes;
    }
    // metodo para buscar o carro dentro de uma array list com os carros ja cadastrados dentro da tabela 
    public List<informacoesCarro> buscarCarro(String placa) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<informacoesCarro> listaInformacoes = new ArrayList<>();
        
        try {
            stmt = connect.prepareStatement("SELECT * FROM informacoes_carro WHERE placa LIKE ?");
            stmt.setString(1, "%" + placa + "%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                informacoesCarro informations = new informacoesCarro();
                
                informations.setDono(rs.getString("dono"));
                informations.setAnoDoCarro(rs.getInt("anoDoCarro"));
                informations.setCor(rs.getString("cor"));
                informations.setModelo(rs.getString("modelo"));
                informations.setPlaca(rs.getString("placa"));
                
                listaInformacoes.add(informations);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar a lista!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, rs);
        }
        
        return listaInformacoes;
    }
    
    // metodo para dar o update de novas informacoes de carros ja cadastradados
    public void update (informacoesCarro informationCars) {
        Connection connect = ConnectionFactory.getConnection();  
        PreparedStatement stmt = null;
        
        try {
            stmt = connect.prepareStatement("UPDATE informacoes_carro SET dono = ?, cor = ? WHERE ID_Carro = ?");
            
            stmt.setString(1, informationCars.getDono());
            stmt.setString(2, informationCars.getCor());
            stmt.setInt(3, informationCars.getID_Carro());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao atualizar as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
    
    // metodo para deletar um certo carro no banco de dados 
    public void delete (informacoesCarro informationCars) {
        Connection connect = ConnectionFactory.getConnection();  
        PreparedStatement stmt = null;
        
        try {
            stmt = connect.prepareStatement("DELETE FROM informacoes_carro WHERE ID_Carro = ?");
            
            stmt.setInt(1, informationCars.getID_Carro());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Informações excluídas com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao excluir as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
}
