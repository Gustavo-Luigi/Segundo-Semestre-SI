package mariadbcrud.dao;

import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao implements Dao<User>{

    private ConnectionInfo infoDaConexao;

    public UserDao(ConnectionInfo infoDaConexao){
        this.infoDaConexao = infoDaConexao;
    }


    @Override
    public void insert(User aluno) {
        String sql = "INSERT INTO alunos(name, username, password, email) VALUES (?, ?, ?, ?)";

        Connection conn;
        PreparedStatement pstm;
        try {
            conn = ConnectionFactory.getConexao(this.infoDaConexao);
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getName());
            pstm.setString(2, aluno.getUserName());
            pstm.setString(3, aluno.getPassword());
            pstm.setString(4, aluno.getEmail());

            pstm.execute();

            System.out.println("Contato salvo com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public User update(User aluno) {

        String sql = "UPDATE alunos SET email = ? WHERE id = ?";

        Connection conn;
        PreparedStatement pstm;

        try {
            conn = ConnectionFactory.getConexao(this.infoDaConexao);
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, aluno.getEmail());
            pstm.setString(2, String.valueOf(aluno.getId()));

            pstm.execute();

            System.out.println("Cadastro atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return aluno;
    }

    @Override
    public void delete(Integer id) {

        String sql = "DELETE FROM alunos WHERE id = ?";

        Connection conn;
        PreparedStatement pstm;

        try {
            conn = ConnectionFactory.getConexao(this.infoDaConexao);
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, String.valueOf(id));

            pstm.execute();

            System.out.println("Cadastro excluido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public User findById(Integer id) {
        String sql = "SELECT * FROM alunos";
        User aluno = new User();

        Connection conn;
        PreparedStatement pstm;
        ResultSet rset;
        try {
            conn = ConnectionFactory.getConexao(this.infoDaConexao);
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()) {
                if(rset.getInt("id") == id) {
                    aluno.setId(rset.getInt("id"));
                    aluno.setName(rset.getString("name"));
                    aluno.setEmail(rset.getString("email"));
                    aluno.setUserName(rset.getString("username"));
                    aluno.setPassword(rset.getString("password"));
                    break;
                }
            }
        } catch(Exception e) {
            System.out.println("Falha na leitura dos dados");
            e.printStackTrace();
        }

        return aluno;
    }

    @Override
    public List<User> findAll() {
        String sql = "SELECT * FROM alunos";

        List<User> listaDeAlunos = new ArrayList<>();

        Connection conn;
        PreparedStatement pstm;
        // Classe que irá recuperar os dados do banco (SELECT).
        ResultSet rset;

        try {
            conn = ConnectionFactory.getConexao(this.infoDaConexao);
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()) {
                User aluno = new User();

                aluno.setId(rset.getInt("id"));
                aluno.setName(rset.getString("name"));
                aluno.setEmail(rset.getString("email"));
                aluno.setUserName(rset.getString("username"));
                aluno.setPassword(rset.getString("password"));

                listaDeAlunos.add(aluno);
            }
        } catch(Exception e) {
            System.out.println("Falha na leitura dos dados");
            e.printStackTrace();
        }

        return listaDeAlunos;
    }
}
