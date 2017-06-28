package pl.edu.wat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Created by Adam on 28.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleJokeInputDto {

    String jokeContent;
    String categoryName;
    Token token;

    public SimpleJokeInputDto(String jokeContent, String categoryName, Token token){
        this.jokeContent = jokeContent;
        this.categoryName = categoryName;
        this.token = token;
    }
}
