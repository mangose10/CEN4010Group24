package Group24.LibApp.Models;

public class User {
    private String name;
    private String username;
    private String password;
    private String email;
    private String address;

    // constructor
    public User(String name, String username, String password, String email, String address) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
