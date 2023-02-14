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

    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "securityCode")
    private String securityCode;
    @Column(name = "name")
    private String name;
    @Column(name = "expiration")
    private String expiration;
    @Column(name = "address")
    private String address;

    public CreditCard() {  }

    public CreditCard(int id, String cardNumber, String securityCode, String name, String expiration, String address) {
        this.setId(id);
        this.setCardNumber(cardNumber);
        this.setSecurityCode(securityCode);
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
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
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
        return "CreditCard{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", securityCode='" + securityCode + '\'' +
                ", name='" + name + '\'' +
                ", expiration='" + expiration + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}