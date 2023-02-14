package Group24.LibApp.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findById(Integer id);
    List<Book> findByOrderByCopiesSoldDesc();
    List<Book> findByRatingGreaterThan(double rating);
}
