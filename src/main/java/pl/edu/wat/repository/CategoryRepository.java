package pl.edu.wat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.model.Category;

/**
 * Created by Adam on 27.06.2017.
 */
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
