package mariadbcrud.dao;

import mariadbcrud.model.ConnectionInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    public static Connection getConexao(ConnectionInfo infoDaConexao) {
        String database = infoDaConexao.getDatabase();
        String url = "jdbc:mysql://localhost:3306/"+database+"?useSSL=false";
        String user = infoDaConexao.getUser();
        String password = infoDaConexao.getPassword();

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            Logger lgr = Logger.getLogger(ConnectionFactory.class.getName());
            lgr.log(Level.SEVERE, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    //TODO: Realizar sobrescrita de método  [ getConexao() ] para receber um aparametro [ ConnectionInfo ] e subtibituir os dados da url de conexão pelos dados do parametro recebido.
}
