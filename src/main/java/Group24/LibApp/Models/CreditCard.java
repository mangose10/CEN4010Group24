package Group24.LibApp.Models;

public class CreditCard {
    private String number;
    private String cvv;
    private String expirationDate;

    // constructor
    public CreditCard(String number, String cvv, String expirationDate) {
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    // getters
    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    // setters
    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}
