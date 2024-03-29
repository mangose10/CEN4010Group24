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
    private int id;

    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "user_id")
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
                ", book_id='" + String.valueOf(bookId) + '\'' +
                ", user_id='" + String.valueOf(userId) + '\'' +
                '}';
    }
}