package pl.edu.wat.service.interfaces;

import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.dto.SimpleJokeDtoInput;
import pl.edu.wat.model.Joke;

import java.util.List;
import java.util.Optional;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface JokeService {
    Joke addSimpleJoke(SimpleJokeDtoInput simpleJokeDtoInput);
    void addJoke(Joke joke);
    List<SimpleJokeDto> listJokeByCategory(String categoryName);
    void cleanJokes();
    SimpleJokeDto likeOrUnlikeJoke(int id, String likeOrUnlike);
}
