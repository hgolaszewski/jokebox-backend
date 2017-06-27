package pl.edu.wat.service;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.model.Category;
import pl.edu.wat.model.Joke;
import pl.edu.wat.repository.JokeRepository;
import pl.edu.wat.service.interfaces.JokeService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Hubert on 25.06.2017.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class JokeServiceImpl implements JokeService {

    private final Logger log = LoggerFactory.getLogger(JokeServiceImpl.class);

    JokeRepository jokeRepository;

    @Override
    public void addJoke(Joke joke) {
        log.debug("Request to add joke");
        jokeRepository.save(joke);
    }

    @Override
    public List<Joke> listJokeByCategory(String categoryName) {
        log.debug("Request to list all Jokes by category (list)");
        return jokeRepository.findAllByCategoryRequestparam(categoryName);
    }

    @Override
    public void cleanJokes() {
        log.debug("Request to delete all Jokes");
        jokeRepository.deleteAll();
    }

    @Override
    public List<SimpleJokeDto> findAllByCategoryName(String categoryName){
        log.debug("Request to find all Jokes by category (page)");
        List<Joke> result = jokeRepository.findAllByCategoryRequestparam(categoryName);
        return result.stream()
                .map(joke -> new SimpleJokeDto(joke))
                .collect(Collectors.toList());
    }

}

