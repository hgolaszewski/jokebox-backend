package pl.edu.wat.web.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.dto.SimpleJokeDtoInput;
import pl.edu.wat.model.Category;
import pl.edu.wat.model.Joke;
import pl.edu.wat.repository.CategoryRepository;
import pl.edu.wat.service.JokeProvider;
import pl.edu.wat.service.interfaces.JokeService;

/**
 * Created by Hubert on 25.06.2017.
 */
@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdministrationRestController {

    JokeProvider jokeProvider;
    JokeService jokeService;

    @PostMapping(value = "/addjoke", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> addJoke(@RequestBody SimpleJokeDtoInput simpleJokeDtoInput){
        return ResponseEntity.ok().body(jokeService.addSimpleJoke(simpleJokeDtoInput));
    }

    @PatchMapping(value = "/resetDataBase", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fillDatabase(){
        cleanJokes();
        jokeProvider.init();
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping(value = "/cleanJokes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cleanJokes(){
        jokeService.cleanJokes();
        return ResponseEntity.status(200).build();
    }

}
