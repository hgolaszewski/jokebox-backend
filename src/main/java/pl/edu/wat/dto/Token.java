package pl.edu.wat.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Created by Adam on 28.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Token {

    String value;

}
