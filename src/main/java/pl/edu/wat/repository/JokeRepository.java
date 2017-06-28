package pl.edu.wat.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wat.domain.Joke;

import java.util.List;

/**
 * Created by Adam on 27.06.2017.
 */
public interface JokeRepository extends JpaRepository<Joke, Integer> {
    List<Joke> findAllByCategoryName(String categoryName);
    List<Joke> findAllByCategoryRequestparam(String categoryRequestparam);
    Page<Joke> findAllByCategoryRequestparam(Pageable pageable, String categoryName);
}
