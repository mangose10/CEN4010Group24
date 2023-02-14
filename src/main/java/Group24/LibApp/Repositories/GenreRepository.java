package Group24.LibApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenreName(String genre_name);
}