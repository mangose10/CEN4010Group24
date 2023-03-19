package Group24.LibApp.Models;

public class User {
<<<<<<< Updated upstream
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
=======
    //instantiating variables
    private String username;
    private String password;
    private String name;
    private String email;
    private String address;

    // default constructor
    public User() {
    }

    // constructor
    public User(String username, String password, String name, String email, String address) {
        this.username = username;
        this.password = password;
        this.name = name;
>>>>>>> Stashed changes
        this.email = email;
        this.address = address;
    }

<<<<<<< Updated upstream
    // getters
    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
=======
    // getters and setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
>>>>>>> Stashed changes

    public String getPassword() {
        return password;
    }
<<<<<<< Updated upstream
=======
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
>>>>>>> Stashed changes

    public String getEmail() {
        return email;
    }
<<<<<<< Updated upstream
=======
    
    public void setEmail(String email) {
        this.email = email;
    }
>>>>>>> Stashed changes

    public String getAddress() {
        return address;
    }
<<<<<<< Updated upstream

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

=======
    
>>>>>>> Stashed changes
    public void setAddress(String address) {
        this.address = address;
    }

<<<<<<< Updated upstream
=======
    //returns string of User information
    @Override
    public String toString() {
        return 
        "User [Username:" + username + 
        "\nPassword:" + password + 
        "\nName:" + name + 
        "\nEmail:" + email
        + "\nAddress:" + address + "]";
    }

>>>>>>> Stashed changes
}
