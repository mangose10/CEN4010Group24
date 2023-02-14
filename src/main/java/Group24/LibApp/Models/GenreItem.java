package Group24.LibApp.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genreitem")
public class GenreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "bookId")
    private Integer bookId;
    @Column(name = "genreId")
    private Integer genreId;

    public GenreItem(){}

    public GenreItem(int id, Integer bookId, Integer genreId) {
        this.setId(id);
        this.setBookId(bookId);
        this.setGenreId(genreId);
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

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }

    @Override
    public String toString() {
        return "GenreItem{" +
                "id=" + id +
                ", bookId='" + String.valueOf(bookId) + '\'' +
                ", genreId='" + String.valueOf(genreId) + '\'' +
                '}';
    }
}