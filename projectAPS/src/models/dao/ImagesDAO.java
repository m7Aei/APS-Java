package models.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.bean.images;

public class ImagesDAO {
    public void Save (images imagem) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("INSERT INTO tabela_imagens (imagem) VALUES (?)");
            
            // converter a imagem Buffered em bytes
            /*
                ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
                ImageIO.write((BufferedImage)img, "jpg", bytesImg);
                bytesImg.flush();
                byte[] byteArray = bytesImg.toByteArray();
                bytesImg.close();
            */
            
            stmt.setBytes(1, imagem.getImagem());
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Imagem cadastrada com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar imagem!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
    
    public List<images> listar() {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<images> listaImagens = new ArrayList<>();
        
        try {
            stmt = connect.prepareStatement("SELECT * FROM tabela_imagens");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                images imagem = new images();
                
                imagem.setImagem(rs.getBytes("imagem"));
                imagem.setCodigoImg(rs.getInt("codigoImg"));
                
                listaImagens.add(imagem);
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao mostrar a lista!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, rs);
        }
        
        return listaImagens;
    }
    
    public void delete (images imagem) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connect.prepareStatement("DELETE FROM tabela_imagens WHERE codigoImg = ?");
            
            stmt.setInt(1, imagem.getCodigoImg());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Informa��es exclui�das com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Desculpe, houve um erro ao excluir as informações!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }
}
