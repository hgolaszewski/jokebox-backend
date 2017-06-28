package pl.edu.wat.web.rest.errors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

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

    @ExceptionHandler(NoSuchJokeException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="No such joke with passed id")
    public void handleNoSuchJokeException() {
        logger.debug("handleNoSuchJokeException");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="illegal argument")
    public void handleIllegalArgumentException() {
        logger.debug("handleIllegalArgumentException");
    }

}
