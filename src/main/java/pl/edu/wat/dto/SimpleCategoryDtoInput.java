package pl.edu.wat.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import pl.edu.wat.web.rest.viewModel.Token;

/**
 * Created by Adam on 28.06.2017.
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleCategoryDtoInput {

    String name;
    String requestparam;
    String address;
    Token token;

    public SimpleCategoryDtoInput(String name, String requestparam, String address, Token token){
        this.name = name;
        this.requestparam = requestparam;
        this.address = address;
        this.token = token;
    }
}
