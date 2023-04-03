package Group24.LibApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "homeAddress")
    private String homeAddress;
    @Column(name = "wishlistCount")
    private int wishlistCount;
    @Column(name = "ccId")
    private Integer ccId;

    public User() {  }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(int id, String username, String password, String name, String email, String address, String homeAddress, int wishlistCount, Integer ccId) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setHomeAddress(homeAddress);
        this.setWishlistCount(wishlistCount);
        this.setCCID(ccId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Integer getCCID() {
        return ccId;
    }

    public void setCCID(Integer ccId) {
        this.ccId = ccId;
    }

    public int getWishlistCount() {
        return wishlistCount;
    }

    public void setWishlistCount(int wishlistCount) {
        this.wishlistCount = wishlistCount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", homeAddress='" + homeAddress + '\'' + 
                ", wishlistCount='" + wishlistCount + '\'' +
                ", ccId='" + String.valueOf(ccId) + '\'' +
                '}';
    }
}