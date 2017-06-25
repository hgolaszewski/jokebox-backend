package pl.edu.wat.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.wat.component.Crawler;
import pl.edu.wat.service.interfaces.JokeService;

/**
 * Created by Hubert on 25.06.2017.
 */
@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdministrationRestController {

    Crawler crawler;
    JokeService jokeService;

    @PatchMapping(value = "/filldb", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fillDatabase(){
        cleanJokes();
        crawler.init();
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping(value = "/cleanJokes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cleanJokes(){
        jokeService.cleanJokes();
        return ResponseEntity.status(200).build();
    }

}
