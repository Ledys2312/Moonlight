package Objects;

public class User {

    private int idUser;
    private String name;
    private String surname;
    private String username;
    private String password;

    public User(int id, String name, String surname, String username, String password) {
        this.idUser = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return idUser;
    }

    public void setId(int id) {
        this.idUser = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}