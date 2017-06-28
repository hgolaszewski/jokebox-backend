package pl.edu.wat.web.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.dto.SimpleCategoryInputDto;
import pl.edu.wat.dto.SimpleJokeInputDto;
import pl.edu.wat.domain.Category;
import pl.edu.wat.domain.Joke;
import pl.edu.wat.service.JokeProvider;
import pl.edu.wat.service.interfaces.CategoryService;
import pl.edu.wat.service.interfaces.JokeService;
import pl.edu.wat.service.interfaces.SecurityService;
import pl.edu.wat.dto.LoginPasswordVM;
import pl.edu.wat.dto.Token;

/**
 * Created by Hubert on 25.06.2017.
 */
@RestController
@RequestMapping("/admin")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AdminRestController {

    JokeProvider jokeProvider;
    JokeService jokeService;
    CategoryService categoryService;
    SecurityService securityService;


    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Token> authenticate(@RequestBody LoginPasswordVM loginPasswordVM){
        return ResponseEntity.ok(securityService.authenticate(loginPasswordVM.getLogin(), loginPasswordVM.getPassword()));
    }

    @PostMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity logOut(@RequestBody Token token){
        securityService.authenticateToken(token);
        securityService.logOut();
        return ResponseEntity.ok(null);
    }

    @PostMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> addCategory(@RequestBody SimpleCategoryInputDto simpleCategoryInputDto){
        securityService.authenticateToken(simpleCategoryInputDto.getToken());
        return ResponseEntity.ok(categoryService.addCategory(simpleCategoryInputDto));
    }

    @DeleteMapping(value = "/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> deleteCategory(@PathVariable int id, @RequestBody Token token){
        securityService.authenticateToken(token);
        return ResponseEntity.ok(categoryService.deleteCategory(id));
    }

    @PostMapping(value = "/joke", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> addJoke(@RequestBody SimpleJokeInputDto simpleJokeInputDto){
        securityService.authenticateToken(simpleJokeInputDto.getToken());
        return ResponseEntity.ok(jokeService.addSimpleJoke(simpleJokeInputDto));
    }

    @DeleteMapping(value = "/joke/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> deleteJoke(@PathVariable int id, @RequestBody Token token){
        securityService.authenticateToken(token);
        return ResponseEntity.ok(jokeService.deleteJoke(id));
    }

    @PatchMapping(value = "/resetDataBase", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fillDatabase(@RequestBody Token token){
        cleanJokes(token);
        jokeProvider.provide();
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping(value = "/cleanJokes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cleanJokes(@RequestBody Token token){
        securityService.authenticateToken(token);
        jokeService.cleanJokes();
        return ResponseEntity.status(200).build();
    }

}
