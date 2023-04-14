package Group24.LibApp.Models;
import java.time.LocalDate;

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
    //instantiating variables
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "holderName")
    private String holderName;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "expirationDate")
    private LocalDate expirationDate;
    @Column(name = "cvv")
    private int cvv;

    //default constructor
    public CreditCard() {
    }

    //constructor
    public CreditCard(int id, String username, String holderName, String cardNumber, LocalDate expirationDate, int cvv) {
        this.id = id;
        this.username = username;
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.expirationDate =  expirationDate;
        this.cvv = cvv;
    }

    //getters and setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHolderName() {
        return holderName;
    }
    
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCVV() {
        return cvv;
    }

    public void setCVV(int cvv) {
        this.cvv = cvv;
    }

    //returns string of Credit Card information
    @Override
    public String toString() {
        return 
        "Credit Card [ID:" + id + 
        "\nUsername:" + username + 
        "Holder Name:" + holderName + 
        "\nCard Number:" + cardNumber + 
        "\nExpiration Date:" + expirationDate + 
        "\nCVV:" + cvv + "]";
    }
    
}
