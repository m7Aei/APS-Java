package models.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import models.bean.cadastroUsers;

public class CadastroDAO {

    public void create(cadastroUsers registerUser) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = connect.prepareStatement("INSERT INTO cadastro (nome, email, endereco, cpf, senha) VALUES (?, ?, ?, ?, ?)");

            stmt.setString(1, registerUser.getNome());
            stmt.setString(2, registerUser.getEmail());
            stmt.setString(3, registerUser.getEndereco());
            stmt.setString(4, registerUser.getCpf());
            stmt.setString(5, registerUser.getSenha());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuário cadastro com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt);
        }
    }

    // metodo para checar se existe usuario e fazer o login
    public boolean checkUsers(String email, String senha) {
        Connection connect = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            stmt = connect.prepareStatement("SELECT * FROM cadastro WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
        } finally {
            ConnectionFactory.closeConnection(connect, stmt, rs);
        }

        return check;
    }
}
