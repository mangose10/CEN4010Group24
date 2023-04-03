package Group24.LibApp.Controllers;

import Group24.LibApp.Models.Author;
import Group24.LibApp.Models.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private static Map<Integer, Author> authors = new HashMap<>();
    private static Map<Integer, List<Book>> authorBooks = new HashMap<>();

    @PostMapping
    public ResponseEntity<Object> addAuthor(@RequestBody Author author) {
        int id = authors.size() + 1;
        authors.put(id, author);
        authorBooks.put(id, new ArrayList<>());
        return new ResponseEntity<>("Author is created successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("id") int id) {
        List<Book> books = authorBooks.get(id);
        if (books == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

}
