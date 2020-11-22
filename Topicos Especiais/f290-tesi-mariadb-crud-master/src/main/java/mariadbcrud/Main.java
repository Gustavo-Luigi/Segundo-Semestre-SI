package mariadbcrud;

import mariadbcrud.dao.UserDao;
import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConnectionInfo conexaoFatec = new ConnectionInfo("fatec", "root", "");

        menu(conexaoFatec);
    }

    public static void menu(ConnectionInfo infoDaConexao) {
        boolean sair = false;
        int opcao;
        Scanner sc = new Scanner(System.in);

        while(!sair) {
            System.out.printf("Escolha uma opcao:\n" +
                    "\t1. Registrar aluno\n" +
                    "\t2. Ver registros\n" +
                    "\t3. Editar Email\n" +
                    "\t4. Deletar Registro\n" +
                    "\t5. Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    User.inserirUsuario(infoDaConexao);
                    break;
                case 2:
                    UserDao.read(infoDaConexao);
                    break;
                case 3:
                    UserDao.update(infoDaConexao);
                    break;
                case 4:
                    UserDao.delete(infoDaConexao);
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
}
