package Group24.LibApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlistitem")
public class WishlistItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "wishlistId")
    private Integer wishlistId;

    public WishlistItem(){}

    public WishlistItem(int id, Integer bookId, Integer wishlistId) {
        this.setId(id);
        this.setBookId(bookId);
        this.setWishlistId(wishlistId);
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

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    @Override
    public String toString() {
        return "WishlistItem{" +
                "id=" + id +
                ", bookId='" + String.valueOf(bookId) + '\'' +
                ", wishlistId='" + String.valueOf(wishlistId) + '\'' +
                '}';
    }
}