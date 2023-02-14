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
    @Column(name = "home_address")
    private String home_address;
    @Column(name = "wishlist_count")
    private int wishlist_count;
    @Column(name = "cc_id")
    private Long cc_id;

    public User() {  }

    public User(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public User(int id, String username, String password, String name, String email, String address, String home_address, int wishlist_count, Long cc_id) {
        this.setId(id);
        this.setUsername(username);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setAddress(address);
        this.setHomeAddress(home_address);
        this.setWishlistCount(wishlist_count);
        this.setCCID(cc_id);
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
        return home_address;
    }

    public void setHomeAddress(String home_address) {
        this.home_address = home_address;
    }

    public Long getCCID() {
        return cc_id;
    }

    public void setCCID(Long cc_id) {
        this.cc_id = cc_id;
    }

    public int getWishlistCount() {
        return wishlist_count;
    }

    public void setWishlistCount(int wishlist_count) {
        this.wishlist_count = wishlist_count;
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
                ", home_address='" + home_address + '\'' + 
                ", wishlist_count='" + wishlist_count + '\'' +
                ", cc_id='" + String.valueOf(cc_id) + '\'' +
                '}';
    }
}