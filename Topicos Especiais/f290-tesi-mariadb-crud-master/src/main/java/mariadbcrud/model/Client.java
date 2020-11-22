package mariadbcrud.model;

public class Client {
    private Integer id;
    private String name;
    private String email;

    public Client(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Client() {
    }

    public Integer getId() {
        return id;
    }

    public Client setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Client setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Client setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
