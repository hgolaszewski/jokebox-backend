package pl.edu.wat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.model.Category;
import pl.edu.wat.model.Joke;

import java.util.List;

/**
 * Created by Adam on 27.06.2017.
 */
public interface JokeRepository extends JpaRepository<Joke, Long> {
    List<Joke> findAllByCategoryRequestparam(String categoryName);
    Page<Joke> findAllByCategoryRequestparam(Pageable pageable, String categoryName);
}
