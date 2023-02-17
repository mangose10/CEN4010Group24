package Group24.LibApp.Services;

import java.util.List;


import Group24.LibApp.Models.Book;

public interface SearchService {
    public abstract List<Book> getAllBooks();
    public abstract List<Book> getBooksByGenre(String genres, String operation);
    public abstract List<Book> getTopTenBooks();
    public abstract List<Book> getBookByRating(Double rating);
    public abstract boolean updateBookPriceByDiscount(String publisher, Double discount);
}
