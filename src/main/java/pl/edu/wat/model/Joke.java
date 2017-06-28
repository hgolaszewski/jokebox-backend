package pl.edu.wat.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Created by Hubert on 25.06.2017.
 */
@Entity
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Joke {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    Category category;

    @Column(nullable = false)
    int likeNumber;

    @Column(nullable = false)
    int unlikeNumber;

    public Joke(String content, Category category) {
        this.content = content;
        this.category = category;
        likeNumber = 0;
        unlikeNumber = 0;
    }

}
