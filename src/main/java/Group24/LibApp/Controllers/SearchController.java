package Group24.LibApp.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Group24.LibApp.Models.Book;
import Group24.LibApp.Models.GenreItem;

import Group24.LibApp.Repositories.BookRepository;
import Group24.LibApp.Repositories.GenreItemRepository;
import Group24.LibApp.Repositories.GenreRepository;
import Group24.LibApp.Repositories.RatingRepository;

@RestController
public class SearchController {

    @Autowired
	BookRepository bookRepository;
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    GenreItemRepository genreItemRepository;
    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getAllBooks() {

		try {
			List<Book> books = new ArrayList<Book>();

			bookRepository.findAll().forEach(books::add);

			if (books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam(required = false) String genres, @RequestParam(required = false) String operation) {

		try {
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
                }else
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            if (books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/topSellers")
    public ResponseEntity<List<Book>> getTopTenBooks() {

		try {
			List<Book> books = new ArrayList<Book>();
            
			List<Book> tmp = bookRepository.findByOrderByCopiesSoldDesc();
            tmp.subList(0, tmp.size() < 10 ? tmp.size() : 10).forEach(books::add);

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/rating")
    public ResponseEntity<List<Book>> getBookByRating(@RequestParam(required = false) Double rating) {

		try {
			List<Book> books = new ArrayList<Book>();
            
            if (rating != null)
			    bookRepository.findByRatingGreaterThan(rating).forEach(books::add);

            if (books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PutMapping("/search/updatePriceByDiscount")
	public ResponseEntity<List<Book>> updateBookPriceByDiscount(@RequestParam String publisher, @RequestParam Double discount) {
		List<Book> books = bookRepository.findByPublisher(publisher);
        
		if (!books.isEmpty()) {
            for (Book book : books) {
                Double newPrice = (1 - discount) * book.getPrice();
                book.setPrice(newPrice);
            }
			return new ResponseEntity<>(bookRepository.saveAll(books), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
 