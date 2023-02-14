package Group24.LibApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shoppingcartitem")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "userId")
    private Integer userId;

    public ShoppingCartItem() {}

    public ShoppingCartItem(int id, Integer bookId, Integer userId) {
        this.setId(id);
        this.setBookId(bookId);
        this.setUserId(userId);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "id=" + id +
                ", bookId='" + String.valueOf(bookId) + '\'' +
                ", userId='" + String.valueOf(userId) + '\'' +
                '}';
    }
}