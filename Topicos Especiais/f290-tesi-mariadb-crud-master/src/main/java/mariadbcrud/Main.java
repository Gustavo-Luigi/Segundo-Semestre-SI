package mariadbcrud;

import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConnectionInfo conexaoFatec = new ConnectionInfo("fatec", "root", "");

        menu(conexaoFatec);

        //TODO: Remover trecho apos validar conexao com o banco de dados.
//        String query = "SELECT VERSION();";
//        try (Statement st = ConnectionFactory.getConexao(conexaoFatec).createStatement();
//             ResultSet rs = st.executeQuery(query)) {
//            if (rs.next()) {
//                System.out.println(rs.getString(1));
//            }
//        } catch (SQLException ex) {
//            Logger lgr = Logger.getLogger(Main.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//        }
    }

    public static void menu(ConnectionInfo infoDaConexao) {
        boolean sair = false;
        int opcao;
        Scanner sc = new Scanner(System.in);

        while(!sair) {
            System.out.printf("Escolha uma opcao:\n" +
                    "\t1. Registrar aluno\n" +
                    "\t2. Ver registros\n" +
                    "\t3. Editar Registro\n" +
                    "\t4. Deletar Registro\n" +
                    "\t5. Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    User.inserirUsuario(infoDaConexao);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }

    //TODO: Realizar testes de inclusão, leitura, remoção e atualização de dados na entidade [ user ].
}
