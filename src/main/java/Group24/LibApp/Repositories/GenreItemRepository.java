package Group24.LibApp.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.GenreItem;

@Repository
public interface GenreItemRepository extends JpaRepository<GenreItem, Long> {
    List<GenreItem> findByGenreId(Integer genre_id);
}
