package Group24.LibApp.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group24.LibApp.Models.Book;
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
    public List<Book> getBooksByGenre(String genres, String operation) {
        List<Book> books = new ArrayList<Book>();

        if (genres == null)
            bookRepository.findAll().forEach(books::add);
        else {
            List<String> genreNames = Arrays.asList(genres.split(";"));
            int numGenres = genreNames.size();

            List<GenreItem> genreItemObj = new ArrayList<GenreItem>();

            if (operation == null || operation.equals("AND")){
                for (int i = 0; i < numGenres;i++) {
                    List<GenreItem> tmpGenreItem = new ArrayList<GenreItem>();
                    List<Book> tmpBooks = new ArrayList<Book>();

                    int genreId = genreRepository.findByGenreName(genreNames.get(i)).getId();
                    genreItemRepository.findByGenreId(genreId).forEach(tmpGenreItem::add);

                    for (GenreItem genreItem : tmpGenreItem) {
                        Book curBook = bookRepository.findById(genreItem.getBookId());
                        if (!tmpBooks.contains(curBook))
                            tmpBooks.add(curBook);
                    }

                    if (i == 0){
                        books = tmpBooks;
                    }else{
                        for (Book book : books){
                            if (!tmpBooks.contains(book))
                                books.remove(book);
                        }
                    }
                }
            }else if(operation.equals("OR")){
                for (String genre : genreNames) {
                    int genreId = genreRepository.findByGenreName(genre).getId();
                    genreItemRepository.findByGenreId(genreId).forEach(genreItemObj::add);
                }
                for (GenreItem genreItem : genreItemObj) {
                    Book curBook = bookRepository.findById(genreItem.getBookId());
                    if (!books.contains(curBook))
                        books.add(curBook);
                }
            }
        }
        return books;
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
    
}
