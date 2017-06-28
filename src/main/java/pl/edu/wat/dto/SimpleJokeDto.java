package pl.edu.wat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.wat.model.Joke;

import java.io.Serializable;

/**
 * Created by Hubert on 25.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleJokeDto implements Serializable{

    int id;
    String content;
    SimpleCategoryDto category;
    int likeNumber;
    int unlikeNumber;

    public SimpleJokeDto(Joke joke){
        id = joke.getId();
        content = joke.getContent();
        category = new SimpleCategoryDto(joke.getCategory());
        likeNumber = joke.getLikeNumber();
        unlikeNumber = joke.getUnlikeNumber();
    }

}
