package Group24.LibApp.Models;
import java.time.LocalDate;

public class CreditCard {
    //instantiating variables
    private Long id;
    private String holderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private int cvv;

    //default constructor
    public CreditCard() {
    }

    //constructor
    public CreditCard(String holderName, String cardNumber, LocalDate expirationDate, int cvv) {
        this.holderName = holderName;
        this.cardNumber = cardNumber;
        this.expirationDate =  expirationDate;
        this.cvv = cvv;
    }

    //getters and setters
    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
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
        "CreditCard [ID:" + id + 
        "\nHolder Name:" + holderName + 
        "\nCard Number:" + cardNumber + 
        "\n Expiration Date:" + expirationDate + 
        "\nCVV:" + cvv + "]";
    }
}
