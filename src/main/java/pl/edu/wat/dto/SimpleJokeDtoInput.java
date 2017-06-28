package pl.edu.wat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.wat.model.Joke;

/**
 * Created by Adam on 28.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleJokeDtoInput {

    String jokeContent;
    String categoryName;

    public SimpleJokeDtoInput(String jokeContent, String categoryName){
        this.jokeContent = jokeContent;
        this.categoryName = categoryName;
    }
}
