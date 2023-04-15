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
import Group24.LibApp.Services.SearchService;

@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<List<Book>> getAllBooks() {

		try {
			List<Book> books = new ArrayList<Book>();
            searchService.getAllBooks().forEach(books::add);

			if (books.isEmpty()) 
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/genre")
    public ResponseEntity<List<Book>> getBooksByGenre(@RequestParam(required = false) String genres, @RequestParam(required = false) String operation) {
        
        List<Book> books = new ArrayList<Book>();

		try {
            if (genres == null) {
                searchService.getAllBooks().forEach(books::add);
            }else {

                List<String> genreNames = Arrays.asList(genres.split(";"));
                int numGenres = genreNames.size();

                List<GenreItem> genreItemObj = new ArrayList<GenreItem>();

                if (operation == null || operation.equals("AND")){
                    for (int i = 0; i < numGenres;i++) {
                        List<GenreItem> tmpGenreItem = new ArrayList<GenreItem>();
                        List<Book> tmpBooks = new ArrayList<Book>();

                        int genreId = searchService.getGenreByName(genreNames.get(i)).getId();
                        searchService.getGenreItemByGenreId(genreId).forEach(tmpGenreItem::add);

                        for (GenreItem genreItem : tmpGenreItem) {
                            Book curBook = searchService.getBooksById(genreItem.getBookId());
                            if (!tmpBooks.contains(curBook))
                                tmpBooks.add(curBook);
                        }

                        if (i == 0){
                            books = tmpBooks;
                        }else{
                            List<Book> tmp2Books = new ArrayList<Book>();
                            for (Book book : books){
                                if (tmpBooks.contains(book)){
                                    tmp2Books.add(book);
                                }
                            }
                            books = tmp2Books;
                        }
                    }
                }else if(operation.equals("OR")){
                    for (String genre : genreNames) {
                        int genreId = searchService.getGenreByName(genre).getId();
                        searchService.getGenreItemByGenreId(genreId).forEach(genreItemObj::add);
                    }
                    for (GenreItem genreItem : genreItemObj) {
                        Book curBook = searchService.getBooksById(genreItem.getBookId());
                        if (!books.contains(curBook))
                            books.add(curBook);
                    }
                }
            }
            if (books.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/topSellers")
    public ResponseEntity<List<Book>> getTopTenBooks() {

		try {
			List<Book> books = new ArrayList<Book>();
            
			searchService.getTopTenBooks().forEach(books::add);

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @GetMapping("/search/rating")
    public ResponseEntity<List<Book>> getBookByRating(@RequestParam(required = false) Double rating) {

		try {
			List<Book> books = new ArrayList<Book>();
            
            if(rating != null)
                searchService.getBookByRating(rating).forEach(books::add);
            else
                searchService.getAllBooks().forEach(books::add);

            if (books.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(books, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PutMapping("/search/updatePriceByDiscount")
	public ResponseEntity<String> updateBookPriceByDiscount(@RequestParam String publisher, @RequestParam Double discount) {
        
		if (searchService.updateBookPriceByDiscount(publisher, discount))
			return new ResponseEntity<>(HttpStatus.OK);
		
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
 