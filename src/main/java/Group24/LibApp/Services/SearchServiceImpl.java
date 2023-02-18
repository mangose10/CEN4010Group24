package Group24.LibApp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Models.Genre;
import Group24.LibApp.Models.GenreItem;
import Group24.LibApp.Repositories.BookRepository;
import Group24.LibApp.Repositories.GenreItemRepository;
import Group24.LibApp.Repositories.GenreRepository;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    GenreItemRepository genreItemRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBooksById(Integer id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> getTopTenBooks() {
        List<Book> tmp = bookRepository.findByOrderByCopiesSoldDesc();
        return tmp.subList(0, tmp.size() < 10 ? tmp.size() : 10);
    }

    @Override
    public List<Book> getBookByRating(Double rating) {
        return bookRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public boolean updateBookPriceByDiscount(String publisher, Double discount) {
        List<Book> books = bookRepository.findByPublisher(publisher);
        
		if (!books.isEmpty()) {
            for (Book book : books) {
                Double newPrice = (1 - discount) * book.getPrice();
                book.setPrice(newPrice);
            }
			bookRepository.saveAll(books);
            return true;
		}

        return false;
    }

    @Override
    public Genre getGenreByName(String name) {
        return genreRepository.findByGenreName(name);
    }

    @Override
    public List<GenreItem> getGenreItemByGenreId(Integer id) {
        return genreItemRepository.findByGenreId(id);
    }
    
}
