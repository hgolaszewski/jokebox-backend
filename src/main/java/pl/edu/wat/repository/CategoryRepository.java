package pl.edu.wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.domain.Category;

import java.util.Optional;

/**
 * Created by Adam on 27.06.2017.
 */
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Optional<Category> findOneByName(String categoryName);
}
