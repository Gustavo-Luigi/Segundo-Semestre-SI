package mariadbcrud.dao;

import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDao {

    private static Scanner sc = new Scanner(System.in);

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

    public static List<User> read(ConnectionInfo infoDaConexao){
        String sql = "SELECT * FROM alunos";

        List<User> listaDeAlunos = new ArrayList<>();

        Connection conn;
        PreparedStatement pstm;
        // Classe que irá recuperar os dados do banco (SELECT).
        ResultSet rset;

        try {
            conn = ConnectionFactory.getConexao(infoDaConexao);
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while(rset.next()) {
                User aluno = new User("aguardandoDados", "aguardandoDados", "aguardandoDados", "aguardandoDados");

                aluno.setId(rset.getInt("id"));
                aluno.setName(rset.getString("name"));
                aluno.setEmail(rset.getString("email"));
                aluno.setUserName(rset.getString("username"));
                aluno.setPassword(rset.getString("password"));

                listaDeAlunos.add(aluno);

                System.out.printf("ID: %d\n" +
                        "Nome: %s\n" +
                        "Apelido: %s\n" +
                        "E-mail: %s\n" +
                        "************\n", aluno.getId(), aluno.getName(), aluno.getUserName(), aluno.getEmail());
            }

        } catch(Exception e) {
            System.out.println("Falha na leitura dos dados");
            e.printStackTrace();
        }

        return listaDeAlunos;
    }

    public static void update(ConnectionInfo infoDaConexao) {
        int idDesejado;
        boolean idExiste = false;
        List<User> listaDeAlunos = UserDao.read(infoDaConexao);

        System.out.println("Qual email deseja editar? (Escolha pelo ID do aluno)");
        idDesejado = sc.nextInt();
        sc.nextLine();
        for (User aluno: listaDeAlunos) {
            if(aluno.getId() == idDesejado){
                idExiste = true;
                break;
            }
        }

        if(idExiste){
            String email;
            String id = String.valueOf(idDesejado);
            System.out.println("Digite o novo email do aluno:");
            email = sc.nextLine();
            String sql = "UPDATE alunos SET email = ? WHERE id = ?";

            Connection conn;
            PreparedStatement pstm;

            try {
                conn = ConnectionFactory.getConexao(infoDaConexao);
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, email);
                pstm.setString(2, id);

                pstm.execute();

                System.out.println("Email atualizado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID inválido!");
        }
    }

    public static void delete(ConnectionInfo infoDaConexao){
        int idDesejado;
        boolean idExiste = false;
        List<User> listaDeAlunos = UserDao.read(infoDaConexao);

        System.out.println("Qual cadastro de aluno deseja excluir? (Escolha pelo ID do aluno)");
        idDesejado = sc.nextInt();
        sc.nextLine();
        for (User aluno: listaDeAlunos) {
            if(aluno.getId() == idDesejado){
                idExiste = true;
                break;
            }
        }

        if(idExiste){
            String id = String.valueOf(idDesejado);
            System.out.println("Digite o novo email do aluno:");
            String sql = "DELETE FROM alunos WHERE id = ?";

            Connection conn;
            PreparedStatement pstm;

            try {
                conn = ConnectionFactory.getConexao(infoDaConexao);
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, id);

                pstm.execute();

                System.out.println("Cadastro excluido com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("ID inválido!");
        }
    }
}
