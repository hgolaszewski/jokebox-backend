package pl.edu.wat.service;

import org.springframework.stereotype.Service;
import pl.edu.wat.service.interfaces.SecurityService;
import pl.edu.wat.web.rest.errors.AdminAlreadyAuthenticatedException;
import pl.edu.wat.web.rest.errors.AuthenticateException;
import pl.edu.wat.web.rest.viewModel.Token;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Adam on 28.06.2017.
 */

@Transactional
@Service
public class SecurityServiceImpl implements SecurityService {

    private final static String LOGIN = "admin";
    private final static String PASSWORD = "password";
    private final static SecureRandom secureRandom = new SecureRandom();
    private String currentSessionId = null;


    @Override
    public Token authenticate(String user, String password) {
        if(currentSessionId != null){
            throw new AdminAlreadyAuthenticatedException();
        }else if (LOGIN.equals(user) && PASSWORD.equals(password)){
            currentSessionId = nextSessionId();
        } else {
            throw new AuthenticateException();
        }
        return new Token(currentSessionId);
    }

    private String nextSessionId() {
        return new BigInteger(130, secureRandom).toString(32);
    }

    @Override
    public void authenticateToken(Token token) {
        if(currentSessionId == null || !currentSessionId.equals(token.getValue())){
            throw new AuthenticateException();
        }
    }

    @Override
    public void logOut() {
        currentSessionId = null;
    }

}
