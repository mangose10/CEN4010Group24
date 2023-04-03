package Group24.LibApp.Controllers;

import Group24.LibApp.Models.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private static Map<String, Book> books = new HashMap<>();

    @PostMapping
    public ResponseEntity<Object> addBook(@RequestBody Book book) {
        books.put(book.getIsbn(), book);
        return new ResponseEntity<>("Book is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

}
