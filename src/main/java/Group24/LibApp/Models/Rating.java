package Group24.LibApp.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rating")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "rating")
    private String rating;
    @Column(name = "datestamp")
    private Date datestamp;

    public Rating(){}

    public Rating(int id, Integer bookId, Integer userId, String rating, Date datestamp) {
        this.setId(id);
        this.setBookId(bookId);
        this.setUserId(userId);
        this.setRating(rating);
        this.setDatestamp(datestamp);
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", bookId='" + String.valueOf(bookId) + '\'' +
                ", userId='" + String.valueOf(userId) + '\'' +
                ", rating='" + rating + '\'' +
                ", datestamp='" + String.valueOf(datestamp) + '\'' +
                '}';
    }
}