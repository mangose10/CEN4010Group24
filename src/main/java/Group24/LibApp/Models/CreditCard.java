package Group24.LibApp.Models;

public class CreditCard {
    private String user;
    private String number;
    private int cvv;
    private String expirationDate;

    // constructor
    public CreditCard(String user, String number, int cvv, String expirationDate) {
        this.user = user;
        this.number = number;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    // getters
    public String getUser() {
        return user;
    }

    public String getNumber() {
        return number;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    // setters
    public void setUser(String user) {
        this.user = user;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

}
