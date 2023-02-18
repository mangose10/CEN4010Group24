package Group24.LibApp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Models.Genre;
import Group24.LibApp.Models.GenreItem;

@Service
public interface SearchService {
    public abstract List<Book> getAllBooks();
    public abstract Book getBooksById(Integer id);
    public abstract List<Book> getTopTenBooks();
    public abstract List<Book> getBookByRating(Double rating);
    public abstract boolean updateBookPriceByDiscount(String publisher, Double discount);
    public abstract Genre getGenreByName(String name);
    public abstract List<GenreItem> getGenreItemByGenreId(Integer id);
}
