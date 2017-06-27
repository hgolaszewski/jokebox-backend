package pl.edu.wat.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.model.Category;
import pl.edu.wat.model.Joke;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface JokeService {
    void addJoke(Joke joke);
    List<Joke> listJokeByCategory(String categoryName);
    void cleanJokes();
    List<SimpleJokeDto> findAllByCategoryName(String categoryName);
}
