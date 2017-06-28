package pl.edu.wat.service.interfaces;

import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.dto.SimpleJokeInputDto;
import pl.edu.wat.domain.Joke;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface JokeService {
    Joke addSimpleJoke(SimpleJokeInputDto simpleJokeInputDto);
    void addJoke(Joke joke);
    Joke deleteJoke(int id);
    List<SimpleJokeDto> listJokeByCategory(String categoryName);
    void cleanJokes();
    SimpleJokeDto likeOrUnlikeJoke(int id, String likeOrUnlike);
}
