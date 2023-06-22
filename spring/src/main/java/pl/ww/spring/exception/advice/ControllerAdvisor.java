package pl.ww.spring.exception.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import pl.ww.spring.exception.NoFichesException;
import pl.ww.spring.exception.NoLanguagesException;
import pl.ww.spring.exception.NotEnoughFichesException;
import pl.ww.spring.exception.NotFoundException;

@ControllerAdvice
public class ControllerAdvisor {

    private final Logger logger = LoggerFactory.getLogger(ControllerAdvisor.class);

    @ExceptionHandler(NotFoundException.class)
    public String handle404Exception(NotFoundException ex) {
        if (ex != null) {
            logger.warn(ex.getMessage());
        }
        return "error/not_found";
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException (NoHandlerFoundException e) {
        return "error/not_found";
    }

    @ExceptionHandler(NoFichesException.class)
    public String handleNoFichesException(NoFichesException ex) {
        if (ex != null) {
            logger.warn(ex.getMessage());
        }
        return "error/no_fiches";
    }

    @ExceptionHandler(NoLanguagesException.class)
    public String handleNoLanguagesException(NoLanguagesException ex) {
        if (ex != null) {
            logger.warn(ex.getMessage());
        }
        return "error/no_languages";
    }

    @ExceptionHandler(NotEnoughFichesException.class)
    public String handleNotEnoughFichesException(NotEnoughFichesException ex) {
        if (ex != null) {
            logger.warn(ex.getMessage());
        }
        return "error/not_enough_fiches";
    }

    @ExceptionHandler(Throwable.class)
    public String handle500Exception(Throwable ex) {
        if (ex != null) {
            logger.error("Unexpected error...", ex);
        }
        return "error/error";
    }

}
