package pl.edu.wat.web.rest.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.edu.wat.web.rest.errors.*;

/**
 * Created by Adam on 28.06.2017.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerExceptionHandler.class);

    @ExceptionHandler(NoSuchCategoryException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such category name")
    public void handleNoSuchCategoryException() {
        logger.debug("handleNoSuchCategoryException ");
    }

    @ExceptionHandler(DuplicateJokeExeption.class)
    @ResponseStatus(value= HttpStatus.CONFLICT, reason="Familiar joke already exist")
    public void handleDuplicateJokeExeption() {
        logger.debug("handleNoSuchCategoryException ");
    }

    @ExceptionHandler(NoSuchJokeException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such joke with passed id")
    public void handleNoSuchJokeException() {
        logger.debug("handleNoSuchJokeException");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Illegal argument")
    public void handleIllegalArgumentException() {
        logger.debug("handleIllegalArgumentException");
    }

    @ExceptionHandler(AuthenticateException.class)
    @ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Wrong login or password or token")
    public void handleAuthenticateException() {
        logger.debug("handleAuthenticateException");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Something went wrong")
    public void handleAdminAlreadyAuthenticatedException() {
        logger.debug("handleAdminAlreadyAuthenticatedException");
    }

}
