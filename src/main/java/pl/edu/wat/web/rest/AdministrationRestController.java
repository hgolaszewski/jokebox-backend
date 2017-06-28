package pl.edu.wat.web.rest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.dto.SimpleCategoryDtoInput;
import pl.edu.wat.dto.SimpleJokeDto;
import pl.edu.wat.dto.SimpleJokeDtoInput;
import pl.edu.wat.model.Category;
import pl.edu.wat.model.Joke;
import pl.edu.wat.repository.CategoryRepository;
import pl.edu.wat.service.JokeProvider;
import pl.edu.wat.service.interfaces.CategoryService;
import pl.edu.wat.service.interfaces.JokeService;
import pl.edu.wat.service.interfaces.SecurityService;
import pl.edu.wat.web.rest.viewModel.LoginPasswordVM;
import pl.edu.wat.web.rest.viewModel.Token;

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
    public ResponseEntity<Category> addCategory(@RequestBody SimpleCategoryDtoInput simpleCategoryDtoInput){
        securityService.authenticateToken(simpleCategoryDtoInput.getToken());
        return ResponseEntity.ok(categoryService.addCategory(simpleCategoryDtoInput));
    }

    @PostMapping(value = "/joke", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> addJoke(@RequestBody SimpleJokeDtoInput simpleJokeDtoInput){
        securityService.authenticateToken(simpleJokeDtoInput.getToken());
        return ResponseEntity.ok(jokeService.addSimpleJoke(simpleJokeDtoInput));
    }

    @DeleteMapping(value = "/joke/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Joke> deleteJoke(@PathVariable int id, @RequestBody Token token){
        securityService.authenticateToken(token);
        return ResponseEntity.ok(jokeService.deleteJoke(id));
    }

    @PatchMapping(value = "/resetDataBase", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity fillDatabase(@RequestBody Token token){
        cleanJokes(token);
        jokeProvider.init();
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping(value = "/cleanJokes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity cleanJokes(@RequestBody Token token){
        securityService.authenticateToken(token);
        jokeService.cleanJokes();
        return ResponseEntity.status(200).build();
    }

}
