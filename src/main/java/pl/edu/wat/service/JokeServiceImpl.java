package pl.edu.wat.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wat.dao.interfaces.JokeDao;
import pl.edu.wat.model.Joke;
import pl.edu.wat.service.interfaces.JokeService;

import java.util.List;

/**
 * Created by Hubert on 25.06.2017.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JokeServiceImpl implements JokeService {

    JokeDao jokeDao;

    @Override
    public void addJoke(Joke joke) {
        jokeDao.addJoke(joke);
    }

    @Override
    public List<Joke> listJokeByCategory(String category) {
        return jokeDao.listJokeByCategory(category);
    }

    @Override
    public void cleanJokes() {
        jokeDao.cleanJokes();
    }
}

