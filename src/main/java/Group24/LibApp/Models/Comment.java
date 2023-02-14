package Group24.LibApp.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "comment")
    private String comment;
    @Column(name = "datestamp")
    private Date datestamp;

    public Comment() {  }

    public Comment(int id, Integer bookId, Integer userId, String comment, Date datestamp) {
        this.setId(id);
        this.setBookId(bookId);
        this.setUserId(userId);
        this.setComment(comment);
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(Date datestamp) {
        this.datestamp = datestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", bookId='" + String.valueOf(bookId) + '\'' +
                ", userId='" + String.valueOf(userId) + '\'' +
                ", comment='" + comment + '\'' +
                ", datestamp='" + String.valueOf(datestamp) + '\'' +
                '}';
    }
}