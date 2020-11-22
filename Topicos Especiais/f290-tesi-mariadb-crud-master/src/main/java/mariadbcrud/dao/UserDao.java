package mariadbcrud.dao;

import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDao {


    //TODO: Adicionar os metodos para manipulação de dados na entidade [ user ]
    public static void create(User usuario, ConnectionInfo infoDaConexao) {
        String name = usuario.getName();
        String userName = usuario.getUserName();
        String password = usuario.getPassword();
        String email = usuario.getEmail();
        String sql = "INSERT INTO alunos(name, username, password, email) VALUES (?, ?, ?, ?)";

        Connection conn;
        PreparedStatement pstm;
        try {
            conn = ConnectionFactory.getConexao(infoDaConexao);
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            pstm.setString(2, userName);
            pstm.setString(3, password);
            pstm.setString(4, email);

            pstm.execute();

            System.out.println("Contato salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
