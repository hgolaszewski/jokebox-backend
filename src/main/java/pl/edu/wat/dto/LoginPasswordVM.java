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
public class LoginPasswordVM {

    String login;
    String password;

    public LoginPasswordVM(String login, String password){
        this.login = login;
        this.password = password;
    }
}
