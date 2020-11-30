package mariadbcrud.model;

import mariadbcrud.dao.UserDao;

import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private String email;
    private String userName;
    private String password;
    private int id;

    public User(){

    }

    public User(String name, String email, String userName, String password) {
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static User newInstance(){
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("Digite os dados:");
        System.out.print("Nome: ");
        user.name = sc.nextLine();
        System.out.print("E-mail: ");
        user.email = sc.nextLine();
        System.out.print("Apelido: ");
        user.userName = sc.nextLine();
        System.out.print("Senha: ");
        user.password = sc.nextLine();

        return user;
    }


    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public User setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
