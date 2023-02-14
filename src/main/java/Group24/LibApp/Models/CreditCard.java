package Group24.LibApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "creditcard")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "card_number")
    private String card_number;
    @Column(name = "security_code")
    private String security_code;
    @Column(name = "name")
    private String name;
    @Column(name = "expiration")
    private String expiration;
    @Column(name = "address")
    private String address;

    public CreditCard(int id, String card_number, String security_code, String name, String expiration, String address) {
        this.setId(id);
        this.setCardNumber(card_number);
        this.setSecurityCode(security_code);
        this.setName(name);
        this.setExpiration(expiration);
        this.setAddress(address);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return card_number;
    }

    public void setCardNumber(String card_number) {
        this.card_number = card_number;
    }

    public String getSecurityCode() {
        return security_code;
    }

    public void setSecurityCode(String security_code) {
        this.security_code = security_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + card_number + '\'' +
                ", password='" + security_code + '\'' +
                ", name='" + name + '\'' +
                ", email='" + expiration + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}