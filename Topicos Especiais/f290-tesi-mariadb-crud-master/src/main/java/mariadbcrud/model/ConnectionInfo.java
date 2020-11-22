package mariadbcrud.model;

/**
 * Classe responsavel por encapsular os dados para conexoes com bando de dados distintos
 */
public class ConnectionInfo {
    private String database;
    private String user;
    private String password;

    public ConnectionInfo(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;
    }

    public String getDatabase() {
        return database;
    }

    public ConnectionInfo setDatabase(String database) {
        this.database = database;
        return this;
    }

    public String getUser() {
        return user;
    }

    public ConnectionInfo setUser(String user) {
        this.user = user;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public ConnectionInfo setPassword(String password) {
        this.password = password;
        return this;
    }
}
