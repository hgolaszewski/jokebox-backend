package pl.edu.wat.service.interfaces;

import pl.edu.wat.dto.Token;

/**
 * Created by Adam on 28.06.2017.
 */
public interface SecurityService {
    Token authenticate(String user, String password);
    void authenticateToken(Token token);
    void logOut();
}
