package pl.edu.wat.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.edu.wat.domain.Category;
import pl.edu.wat.domain.Joke;
import pl.edu.wat.service.interfaces.JokeService;
import pl.edu.wat.service.interfaces.CategoryService;

import java.io.IOException;
import java.util.List;


/**
 * Created by Hubert on 16.06.2017.
 */

/**
 * There is Service to provide jokes form third sites.
 *
 * TODO: methods which provide filling database by category etc.
 * TODO: also need to be created interface.
 */
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC, onConstructor = @__(@Autowired))
public class JokeProvider {

    CategoryService categoryService;
    JokeService jokeService;

    public void provide() {

        List<Category> categories = categoryService.listAllCategory();

        categories.forEach(category -> {

            try {
                Document document = Jsoup.connect(category.getAddress()).get();
                String temp = document.html().replace("<br>", "0newLine0");
                document = Jsoup.parse(temp);
                Elements elements = document.select("div.dowcip p");

                elements.stream()
                        .map(joke -> joke.text())
                        .map(joke -> joke.replaceAll("0newLine0", "\n"))
                        .filter(joke -> !joke.contains("Stały"))
                        .filter(joke -> joke.length() > 75)
                        .forEach(content -> {
                            Joke joke = new Joke(content,category);
                            jokeService.addJoke(joke);
                        });

            } catch (IOException e) {
                e.printStackTrace();
            }

        });

    }

}
