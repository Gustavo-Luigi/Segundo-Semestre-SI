package mariadbcrud;

import mariadbcrud.dao.UserDao;
import mariadbcrud.model.ConnectionInfo;
import mariadbcrud.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        menu();
    }

    public static void menu() {
        boolean sair = false;
        int opcao, id;
        String email;

        ConnectionInfo conexaoFatec = new ConnectionInfo("fatec", "root", "");
        UserDao daoFatec = new UserDao(conexaoFatec);
        User aluno = new User();
        List<User> listaDeAlunos = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while(!sair) {
            System.out.printf("Escolha uma opcao:\n" +
                    "\t1. Registrar aluno\n" +
                    "\t2. Ver todos os registros\n" +
                    "\t3. Ver um registro\n" +
                    "\t4. Editar Email\n" +
                    "\t5. Deletar Registro\n" +
                    "\t6. Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    aluno = User.newInstance();
                    daoFatec.insert(aluno);
                    break;
                case 2:
                    listaDeAlunos = daoFatec.findAll();
                    Main.mostrarListaDeAlunos(listaDeAlunos);
                    break;
                case 3:
                    System.out.println("Qual ID deseja procurar?");
                    id = sc.nextInt();
                    sc.nextLine();
                    aluno = daoFatec.findById(id);
                    mostrarAluno(aluno);
                    break;
                case 4:
                    System.out.println("Qual ID do aluno que deseja alterar o e-mail?");
                    id = sc.nextInt();
                    sc.nextLine();
                    aluno = daoFatec.findById(id);
                    if(aluno.getName() != null){
                        System.out.println("Qual o novo email?");
                        email = sc.nextLine();
                        aluno.setEmail(email);
                        daoFatec.update(aluno);
                    } else {
                        System.out.println("Ocorreu um erro, verifique o ID do usuario.");
                    }

                    break;
                case 5:
                    System.out.println("Digite o ID do usuario que deseja excluir");
                    id = sc.nextInt();
                    sc.nextLine();
                    aluno = daoFatec.findById(id);
                    if(aluno.getName() != null) {
                        daoFatec.delete(id);
                    } else {
                        System.out.println("Ocorreu um erro, verifique o ID do usuario.");
                    }
                    break;
                case 6:
                    sair = true;
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }

    public static void mostrarListaDeAlunos(List<User> listaDeAlunos) {

        for(User aluno: listaDeAlunos) {
            mostrarAluno(aluno);
        }
    }

    public static void mostrarAluno(User aluno) {
        if(aluno.getName() != null){
            System.out.printf("ID: %d\n" +
                    "Nome: %s\n" +
                    "Apelido: %s\n" +
                    "E-mail: %s\n" +
                    "************\n", aluno.getId(), aluno.getName(), aluno.getUserName(), aluno.getEmail());
            } else {
                System.out.println("Aluno não encontrado!");
            }
        }


}
