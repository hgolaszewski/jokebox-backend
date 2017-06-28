package pl.edu.wat.service.interfaces;

import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.model.Joke;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface JokeService {
    void addJoke(Joke joke);
    List<SimpleJokeDto> listJokeByCategory(String categoryName);
    void cleanJokes();
    List<SimpleJokeDto> findAllByCategoryName(String categoryName);
}
