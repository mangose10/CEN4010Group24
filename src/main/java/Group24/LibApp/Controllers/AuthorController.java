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
    private int authorId = 0;

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@RequestBody Author author) {
        authorId++;
        authors.put(authorId, author);
        authorBooks.put(authorId, new ArrayList<>());
        return new ResponseEntity<>(new AuthorResponse(authorId, "Author is created successfully"), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/books")
    public ResponseEntity<Object> addBookToAuthor(@PathVariable("id") int id, @RequestBody Book book) {
        List<Book> books = authorBooks.get(id);
        if (books == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        books.add(book);
        return new ResponseEntity<>("Book is added to author successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}/books")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("id") int id) {
        List<Book> books = authorBooks.get(id);
        if (books == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    public static class AuthorResponse {
        private int id;
        private String message;

        public AuthorResponse(int id, String message) {
            this.id = id;
            this.message = message;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
