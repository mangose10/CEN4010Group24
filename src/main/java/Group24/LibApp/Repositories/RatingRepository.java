package Group24.LibApp.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group24.LibApp.Models.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating findById(Integer id);
    List<Rating> findByRatingGreaterThan(double rating);
}
