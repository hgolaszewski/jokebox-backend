package pl.edu.wat.dao.interfaces;

import pl.edu.wat.model.Joke;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
public interface JokeDao {
    void addJoke(Joke joke);
    void cleanJokes();
    List<Joke> listJokeByCategory(String category);
}
